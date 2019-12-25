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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes6.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View gck;
    private NewUserGuideModel kiG;
    private NewUserGuideActivity kiY;
    private TbImageView kjf;
    private TbImageView kjg;
    private TbImageView kjh;
    private TbImageView kji;
    private TbImageView kjj;
    private TbImageView kjk;
    private TbImageView kjl;
    private TbImageView kjm;
    private TbImageView kjn;
    private TbImageView kjo;
    private Button kjp;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> kje = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean kjq = false;
    private boolean kjr = true;
    private final View.OnClickListener dmK = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.kjp) {
                    if (NewUserGuideMainFragment.this.kiY.cKM()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.kiY.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.kiY.finish();
                }
            } else if (NewUserGuideMainFragment.this.kjr) {
                NewUserGuideMainFragment.this.kjr = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.kiY, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cKT() {
                        NewUserGuideMainFragment.this.gck.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.gck.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.kjr = true;
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void cKT();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.kjq = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kiY = (NewUserGuideActivity) getBaseFragmentActivity();
        this.kiG = this.kiY.cKO();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.kiG != null && !this.kjq) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.kiY.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.kiG.cKV());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.kje.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.gck = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.kjf = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.kjg = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.kjh = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.kji = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.kjj = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.kjk = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.kjl = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.kjm = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.kjn = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.kjo = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.kjp = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.kje.put(1, this.kjf);
            this.kje.put(2, this.kjg);
            this.kje.put(3, this.kjh);
            this.kje.put(4, this.kji);
            this.kje.put(5, this.kjj);
            this.kje.put(6, this.kjk);
            this.kje.put(7, this.kjl);
            this.kje.put(8, this.kjm);
            this.kje.put(9, this.kjn);
            this.kje.put(10, this.kjo);
            this.kjp.setOnClickListener(this.dmK);
            this.kjf.setOnClickListener(this.dmK);
            this.kjg.setOnClickListener(this.dmK);
            this.kjh.setOnClickListener(this.dmK);
            this.kji.setOnClickListener(this.dmK);
            this.kjj.setOnClickListener(this.dmK);
            this.kjk.setOnClickListener(this.dmK);
            this.kjl.setOnClickListener(this.dmK);
            this.kjm.setOnClickListener(this.dmK);
            this.kjn.setOnClickListener(this.dmK);
            this.kjn.setOnClickListener(this.dmK);
            this.kjo.setOnClickListener(this.dmK);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.kiY.cKQ();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
