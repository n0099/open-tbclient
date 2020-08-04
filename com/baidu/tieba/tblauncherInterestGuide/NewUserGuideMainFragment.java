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
    private TbImageView lUF;
    private TbImageView lUG;
    private TbImageView lUH;
    private TbImageView lUI;
    private TbImageView lUJ;
    private TbImageView lUK;
    private TbImageView lUL;
    private TbImageView lUM;
    private TbImageView lUN;
    private TbImageView lUO;
    private Button lUP;
    private NewUserGuideModel lUg;
    private NewUserGuideActivity lUy;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> lUE = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean lUQ = false;
    private boolean lUR = true;
    private final View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.lUP) {
                    if (NewUserGuideMainFragment.this.lUy.dnF()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.lUy.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.lUy.finish();
                }
            } else if (NewUserGuideMainFragment.this.lUR) {
                NewUserGuideMainFragment.this.lUR = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.lUy, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dnM() {
                        NewUserGuideMainFragment.this.hyy.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.hyy.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.lUR = true;
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void dnM();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.lUQ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lUy = (NewUserGuideActivity) getBaseFragmentActivity();
        this.lUg = this.lUy.dnH();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.lUg != null && !this.lUQ) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.lUy.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.lUg.dnO());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.lUE.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.lUF = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.lUG = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.lUH = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.lUI = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.lUJ = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.lUK = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.lUL = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.lUM = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.lUN = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.lUO = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.lUP = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.lUE.put(1, this.lUF);
            this.lUE.put(2, this.lUG);
            this.lUE.put(3, this.lUH);
            this.lUE.put(4, this.lUI);
            this.lUE.put(5, this.lUJ);
            this.lUE.put(6, this.lUK);
            this.lUE.put(7, this.lUL);
            this.lUE.put(8, this.lUM);
            this.lUE.put(9, this.lUN);
            this.lUE.put(10, this.lUO);
            this.lUP.setOnClickListener(this.eve);
            this.lUF.setOnClickListener(this.eve);
            this.lUG.setOnClickListener(this.eve);
            this.lUH.setOnClickListener(this.eve);
            this.lUI.setOnClickListener(this.eve);
            this.lUJ.setOnClickListener(this.eve);
            this.lUK.setOnClickListener(this.eve);
            this.lUL.setOnClickListener(this.eve);
            this.lUM.setOnClickListener(this.eve);
            this.lUN.setOnClickListener(this.eve);
            this.lUN.setOnClickListener(this.eve);
            this.lUO.setOnClickListener(this.eve);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.lUy.dnJ();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
