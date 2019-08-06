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
    private View fkk;
    private NewUserGuideModel jmW;
    private TbImageView jnA;
    private TbImageView jnB;
    private TbImageView jnC;
    private TbImageView jnD;
    private TbImageView jnE;
    private TbImageView jnF;
    private TbImageView jnG;
    private Button jnH;
    private NewUserGuideActivity jnq;
    private TbImageView jnx;
    private TbImageView jny;
    private TbImageView jnz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> jnw = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean jnI = false;
    private boolean jnJ = true;
    private final View.OnClickListener cmb = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.jnH) {
                    if (NewUserGuideMainFragment.this.jnq.csf()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.jnq.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.jnq.finish();
                }
            } else if (NewUserGuideMainFragment.this.jnJ) {
                NewUserGuideMainFragment.this.jnJ = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.jnq, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void csn() {
                        NewUserGuideMainFragment.this.fkk.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.fkk.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.jnJ = true;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void csn();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.jnI = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jnq = (NewUserGuideActivity) getBaseFragmentActivity();
        this.jmW = this.jnq.csh();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.jmW != null && !this.jnI) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.jnq.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.jmW.csp());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.jnw.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.fkk = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.jnx = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.jny = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.jnz = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.jnA = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.jnB = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.jnC = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.jnD = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.jnE = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.jnF = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.jnG = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.jnH = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.jnw.put(1, this.jnx);
            this.jnw.put(2, this.jny);
            this.jnw.put(3, this.jnz);
            this.jnw.put(4, this.jnA);
            this.jnw.put(5, this.jnB);
            this.jnw.put(6, this.jnC);
            this.jnw.put(7, this.jnD);
            this.jnw.put(8, this.jnE);
            this.jnw.put(9, this.jnF);
            this.jnw.put(10, this.jnG);
            this.jnH.setOnClickListener(this.cmb);
            this.jnx.setOnClickListener(this.cmb);
            this.jny.setOnClickListener(this.cmb);
            this.jnz.setOnClickListener(this.cmb);
            this.jnA.setOnClickListener(this.cmb);
            this.jnB.setOnClickListener(this.cmb);
            this.jnC.setOnClickListener(this.cmb);
            this.jnD.setOnClickListener(this.cmb);
            this.jnE.setOnClickListener(this.cmb);
            this.jnF.setOnClickListener(this.cmb);
            this.jnF.setOnClickListener(this.cmb);
            this.jnG.setOnClickListener(this.cmb);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.jnq.csj();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
