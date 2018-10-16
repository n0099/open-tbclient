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
    private NewUserGuideModel hiR;
    private TbImageView hjA;
    private TbImageView hjB;
    private TbImageView hjC;
    private Button hjD;
    private NewUserGuideActivity hjm;
    private TbImageView hjt;
    private TbImageView hju;
    private TbImageView hjv;
    private TbImageView hjw;
    private TbImageView hjx;
    private TbImageView hjy;
    private TbImageView hjz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> hjs = new Hashtable<>();
    private boolean hiT = false;
    private boolean hjE = false;
    private boolean hjF = true;
    private final View.OnClickListener aOJ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.hjD) {
                    if (NewUserGuideMainFragment.this.hjm.bEp()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.hjm.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.hiT)));
                    NewUserGuideMainFragment.this.hjm.finish();
                }
            } else if (NewUserGuideMainFragment.this.hjF) {
                NewUserGuideMainFragment.this.hjF = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.hjm, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bEx() {
                        NewUserGuideMainFragment.this.dqv.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.dqv.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.hjF = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bEx();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.hjE = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hjm = (NewUserGuideActivity) getBaseFragmentActivity();
        this.hiR = this.hjm.bEr();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.hiR != null && !this.hjE) {
            if (bundle != null) {
                this.hiT = bundle.getBoolean("is_new_user");
            } else {
                this.hiT = this.hjm.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.hiR.bEz());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.hjs.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.hjt = (TbImageView) this.mRoot.findViewById(e.g.icon_1);
            this.hju = (TbImageView) this.mRoot.findViewById(e.g.icon_2);
            this.hjv = (TbImageView) this.mRoot.findViewById(e.g.icon_3);
            this.hjw = (TbImageView) this.mRoot.findViewById(e.g.icon_4);
            this.hjx = (TbImageView) this.mRoot.findViewById(e.g.icon_5);
            this.hjy = (TbImageView) this.mRoot.findViewById(e.g.icon_6);
            this.hjz = (TbImageView) this.mRoot.findViewById(e.g.icon_7);
            this.hjA = (TbImageView) this.mRoot.findViewById(e.g.icon_8);
            this.hjB = (TbImageView) this.mRoot.findViewById(e.g.icon_9);
            this.hjC = (TbImageView) this.mRoot.findViewById(e.g.icon_10);
            this.hjD = (Button) this.mRoot.findViewById(e.g.btn_next);
            this.hjs.put(1, this.hjt);
            this.hjs.put(2, this.hju);
            this.hjs.put(3, this.hjv);
            this.hjs.put(4, this.hjw);
            this.hjs.put(5, this.hjx);
            this.hjs.put(6, this.hjy);
            this.hjs.put(7, this.hjz);
            this.hjs.put(8, this.hjA);
            this.hjs.put(9, this.hjB);
            this.hjs.put(10, this.hjC);
            this.hjD.setOnClickListener(this.aOJ);
            this.hjt.setOnClickListener(this.aOJ);
            this.hju.setOnClickListener(this.aOJ);
            this.hjv.setOnClickListener(this.aOJ);
            this.hjw.setOnClickListener(this.aOJ);
            this.hjx.setOnClickListener(this.aOJ);
            this.hjy.setOnClickListener(this.aOJ);
            this.hjz.setOnClickListener(this.aOJ);
            this.hjA.setOnClickListener(this.aOJ);
            this.hjB.setOnClickListener(this.aOJ);
            this.hjB.setOnClickListener(this.aOJ);
            this.hjC.setOnClickListener(this.aOJ);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.hjm.bEt();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
