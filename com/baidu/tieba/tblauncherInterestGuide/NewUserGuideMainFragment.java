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
    private View flX;
    private NewUserGuideActivity jpL;
    private TbImageView jpS;
    private TbImageView jpT;
    private TbImageView jpU;
    private TbImageView jpV;
    private TbImageView jpW;
    private TbImageView jpX;
    private TbImageView jpY;
    private TbImageView jpZ;
    private NewUserGuideModel jpr;
    private TbImageView jqa;
    private TbImageView jqb;
    private Button jqc;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> jpR = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean jqd = false;
    private boolean jqe = true;
    private final View.OnClickListener cmX = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.jqc) {
                    if (NewUserGuideMainFragment.this.jpL.csT()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.jpL.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.jpL.finish();
                }
            } else if (NewUserGuideMainFragment.this.jqe) {
                NewUserGuideMainFragment.this.jqe = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.jpL, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void ctb() {
                        NewUserGuideMainFragment.this.flX.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.flX.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.jqe = true;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void ctb();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.jqd = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jpL = (NewUserGuideActivity) getBaseFragmentActivity();
        this.jpr = this.jpL.csV();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.jpr != null && !this.jqd) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.jpL.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.jpr.ctd());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.jpR.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.flX = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.jpS = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.jpT = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.jpU = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.jpV = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.jpW = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.jpX = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.jpY = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.jpZ = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.jqa = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.jqb = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.jqc = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.jpR.put(1, this.jpS);
            this.jpR.put(2, this.jpT);
            this.jpR.put(3, this.jpU);
            this.jpR.put(4, this.jpV);
            this.jpR.put(5, this.jpW);
            this.jpR.put(6, this.jpX);
            this.jpR.put(7, this.jpY);
            this.jpR.put(8, this.jpZ);
            this.jpR.put(9, this.jqa);
            this.jpR.put(10, this.jqb);
            this.jqc.setOnClickListener(this.cmX);
            this.jpS.setOnClickListener(this.cmX);
            this.jpT.setOnClickListener(this.cmX);
            this.jpU.setOnClickListener(this.cmX);
            this.jpV.setOnClickListener(this.cmX);
            this.jpW.setOnClickListener(this.cmX);
            this.jpX.setOnClickListener(this.cmX);
            this.jpY.setOnClickListener(this.cmX);
            this.jpZ.setOnClickListener(this.cmX);
            this.jqa.setOnClickListener(this.cmX);
            this.jqa.setOnClickListener(this.cmX);
            this.jqb.setOnClickListener(this.cmX);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.jpL.csX();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
