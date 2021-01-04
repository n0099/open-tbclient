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
/* loaded from: classes2.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private ViewGroup bcK;
    private View iYi;
    private TbImageView nzC;
    private TbImageView nzD;
    private TbImageView nzE;
    private TbImageView nzF;
    private TbImageView nzG;
    private TbImageView nzH;
    private TbImageView nzI;
    private TbImageView nzJ;
    private TbImageView nzK;
    private TbImageView nzL;
    private Button nzM;
    private NewUserGuideModel nzf;
    private NewUserGuideActivity nzv;
    private final Hashtable<Integer, TbImageView> nzB = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean nzN = false;
    private boolean nzO = true;
    private final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.nzM) {
                    if (NewUserGuideMainFragment.this.nzv.dSc()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.nzv.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.nzv.finish();
                }
            } else if (NewUserGuideMainFragment.this.nzO) {
                NewUserGuideMainFragment.this.nzO = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.nzv, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dSj() {
                        NewUserGuideMainFragment.this.iYi.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.iYi.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.nzO = true;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void dSj();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.nzN = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nzv = (NewUserGuideActivity) getBaseFragmentActivity();
        this.nzf = this.nzv.dSe();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.nzf != null && !this.nzN) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.nzv.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.nzf.dSl());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.nzB.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.bcK = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.iYi = this.bcK.findViewById(R.id.root_main_view_cover);
            this.nzC = (TbImageView) this.bcK.findViewById(R.id.icon_1);
            this.nzD = (TbImageView) this.bcK.findViewById(R.id.icon_2);
            this.nzE = (TbImageView) this.bcK.findViewById(R.id.icon_3);
            this.nzF = (TbImageView) this.bcK.findViewById(R.id.icon_4);
            this.nzG = (TbImageView) this.bcK.findViewById(R.id.icon_5);
            this.nzH = (TbImageView) this.bcK.findViewById(R.id.icon_6);
            this.nzI = (TbImageView) this.bcK.findViewById(R.id.icon_7);
            this.nzJ = (TbImageView) this.bcK.findViewById(R.id.icon_8);
            this.nzK = (TbImageView) this.bcK.findViewById(R.id.icon_9);
            this.nzL = (TbImageView) this.bcK.findViewById(R.id.icon_10);
            this.nzM = (Button) this.bcK.findViewById(R.id.btn_next);
            this.nzB.put(1, this.nzC);
            this.nzB.put(2, this.nzD);
            this.nzB.put(3, this.nzE);
            this.nzB.put(4, this.nzF);
            this.nzB.put(5, this.nzG);
            this.nzB.put(6, this.nzH);
            this.nzB.put(7, this.nzI);
            this.nzB.put(8, this.nzJ);
            this.nzB.put(9, this.nzK);
            this.nzB.put(10, this.nzL);
            this.nzM.setOnClickListener(this.onClickListener);
            this.nzC.setOnClickListener(this.onClickListener);
            this.nzD.setOnClickListener(this.onClickListener);
            this.nzE.setOnClickListener(this.onClickListener);
            this.nzF.setOnClickListener(this.onClickListener);
            this.nzG.setOnClickListener(this.onClickListener);
            this.nzH.setOnClickListener(this.onClickListener);
            this.nzI.setOnClickListener(this.onClickListener);
            this.nzJ.setOnClickListener(this.onClickListener);
            this.nzK.setOnClickListener(this.onClickListener);
            this.nzK.setOnClickListener(this.onClickListener);
            this.nzL.setOnClickListener(this.onClickListener);
            return this.bcK;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.nzv.dSg();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
