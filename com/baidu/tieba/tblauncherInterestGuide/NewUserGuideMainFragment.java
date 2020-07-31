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
/* loaded from: classes16.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View hyy;
    private TbImageView lUD;
    private TbImageView lUE;
    private TbImageView lUF;
    private TbImageView lUG;
    private TbImageView lUH;
    private TbImageView lUI;
    private TbImageView lUJ;
    private TbImageView lUK;
    private TbImageView lUL;
    private TbImageView lUM;
    private Button lUN;
    private NewUserGuideModel lUe;
    private NewUserGuideActivity lUw;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> lUC = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean lUO = false;
    private boolean lUP = true;
    private final View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.lUN) {
                    if (NewUserGuideMainFragment.this.lUw.dnE()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.lUw.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.lUw.finish();
                }
            } else if (NewUserGuideMainFragment.this.lUP) {
                NewUserGuideMainFragment.this.lUP = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.lUw, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dnL() {
                        NewUserGuideMainFragment.this.hyy.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.hyy.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.lUP = true;
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void dnL();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.lUO = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lUw = (NewUserGuideActivity) getBaseFragmentActivity();
        this.lUe = this.lUw.dnG();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.lUe != null && !this.lUO) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.lUw.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.lUe.dnN());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.lUC.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.hyy = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.lUD = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.lUE = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.lUF = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.lUG = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.lUH = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.lUI = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.lUJ = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.lUK = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.lUL = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.lUM = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.lUN = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.lUC.put(1, this.lUD);
            this.lUC.put(2, this.lUE);
            this.lUC.put(3, this.lUF);
            this.lUC.put(4, this.lUG);
            this.lUC.put(5, this.lUH);
            this.lUC.put(6, this.lUI);
            this.lUC.put(7, this.lUJ);
            this.lUC.put(8, this.lUK);
            this.lUC.put(9, this.lUL);
            this.lUC.put(10, this.lUM);
            this.lUN.setOnClickListener(this.eve);
            this.lUD.setOnClickListener(this.eve);
            this.lUE.setOnClickListener(this.eve);
            this.lUF.setOnClickListener(this.eve);
            this.lUG.setOnClickListener(this.eve);
            this.lUH.setOnClickListener(this.eve);
            this.lUI.setOnClickListener(this.eve);
            this.lUJ.setOnClickListener(this.eve);
            this.lUK.setOnClickListener(this.eve);
            this.lUL.setOnClickListener(this.eve);
            this.lUL.setOnClickListener(this.eve);
            this.lUM.setOnClickListener(this.eve);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.lUw.dnI();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
