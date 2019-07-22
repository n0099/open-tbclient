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
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes4.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View fjK;
    private NewUserGuideModel jlO;
    private Button jmA;
    private NewUserGuideActivity jmi;
    private TbImageView jmq;
    private TbImageView jmr;
    private TbImageView jms;
    private TbImageView jmt;
    private TbImageView jmu;
    private TbImageView jmv;
    private TbImageView jmw;
    private TbImageView jmx;
    private TbImageView jmy;
    private TbImageView jmz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> jmo = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean jmB = false;
    private boolean jmC = true;
    private final View.OnClickListener clU = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.jmA) {
                    if (NewUserGuideMainFragment.this.jmi.crJ()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.jmi.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.jmi.finish();
                }
            } else if (NewUserGuideMainFragment.this.jmC) {
                NewUserGuideMainFragment.this.jmC = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.jmi, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void crR() {
                        NewUserGuideMainFragment.this.fjK.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.fjK.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.jmC = true;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void crR();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.jmB = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jmi = (NewUserGuideActivity) getBaseFragmentActivity();
        this.jlO = this.jmi.crL();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.jlO != null && !this.jmB) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.jmi.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.jlO.crT());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.jmo.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.fjK = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.jmq = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.jmr = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.jms = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.jmt = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.jmu = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.jmv = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.jmw = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.jmx = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.jmy = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.jmz = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.jmA = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.jmo.put(1, this.jmq);
            this.jmo.put(2, this.jmr);
            this.jmo.put(3, this.jms);
            this.jmo.put(4, this.jmt);
            this.jmo.put(5, this.jmu);
            this.jmo.put(6, this.jmv);
            this.jmo.put(7, this.jmw);
            this.jmo.put(8, this.jmx);
            this.jmo.put(9, this.jmy);
            this.jmo.put(10, this.jmz);
            this.jmA.setOnClickListener(this.clU);
            this.jmq.setOnClickListener(this.clU);
            this.jmr.setOnClickListener(this.clU);
            this.jms.setOnClickListener(this.clU);
            this.jmt.setOnClickListener(this.clU);
            this.jmu.setOnClickListener(this.clU);
            this.jmv.setOnClickListener(this.clU);
            this.jmw.setOnClickListener(this.clU);
            this.jmx.setOnClickListener(this.clU);
            this.jmy.setOnClickListener(this.clU);
            this.jmy.setOnClickListener(this.clU);
            this.jmz.setOnClickListener(this.clU);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.jmi.crN();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
