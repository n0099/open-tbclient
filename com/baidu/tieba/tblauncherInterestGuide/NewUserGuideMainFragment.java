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
    private TbImageView nzB;
    private TbImageView nzC;
    private TbImageView nzD;
    private TbImageView nzE;
    private TbImageView nzF;
    private TbImageView nzG;
    private TbImageView nzH;
    private TbImageView nzI;
    private TbImageView nzJ;
    private TbImageView nzK;
    private Button nzL;
    private NewUserGuideModel nze;
    private NewUserGuideActivity nzu;
    private final Hashtable<Integer, TbImageView> nzA = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean nzM = false;
    private boolean nzN = true;
    private final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.nzL) {
                    if (NewUserGuideMainFragment.this.nzu.dSd()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.nzu.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.nzu.finish();
                }
            } else if (NewUserGuideMainFragment.this.nzN) {
                NewUserGuideMainFragment.this.nzN = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.nzu, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dSk() {
                        NewUserGuideMainFragment.this.iYi.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.iYi.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.nzN = true;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void dSk();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.nzM = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nzu = (NewUserGuideActivity) getBaseFragmentActivity();
        this.nze = this.nzu.dSf();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.nze != null && !this.nzM) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.nzu.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.nze.dSm());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.nzA.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.nzB = (TbImageView) this.bcK.findViewById(R.id.icon_1);
            this.nzC = (TbImageView) this.bcK.findViewById(R.id.icon_2);
            this.nzD = (TbImageView) this.bcK.findViewById(R.id.icon_3);
            this.nzE = (TbImageView) this.bcK.findViewById(R.id.icon_4);
            this.nzF = (TbImageView) this.bcK.findViewById(R.id.icon_5);
            this.nzG = (TbImageView) this.bcK.findViewById(R.id.icon_6);
            this.nzH = (TbImageView) this.bcK.findViewById(R.id.icon_7);
            this.nzI = (TbImageView) this.bcK.findViewById(R.id.icon_8);
            this.nzJ = (TbImageView) this.bcK.findViewById(R.id.icon_9);
            this.nzK = (TbImageView) this.bcK.findViewById(R.id.icon_10);
            this.nzL = (Button) this.bcK.findViewById(R.id.btn_next);
            this.nzA.put(1, this.nzB);
            this.nzA.put(2, this.nzC);
            this.nzA.put(3, this.nzD);
            this.nzA.put(4, this.nzE);
            this.nzA.put(5, this.nzF);
            this.nzA.put(6, this.nzG);
            this.nzA.put(7, this.nzH);
            this.nzA.put(8, this.nzI);
            this.nzA.put(9, this.nzJ);
            this.nzA.put(10, this.nzK);
            this.nzL.setOnClickListener(this.onClickListener);
            this.nzB.setOnClickListener(this.onClickListener);
            this.nzC.setOnClickListener(this.onClickListener);
            this.nzD.setOnClickListener(this.onClickListener);
            this.nzE.setOnClickListener(this.onClickListener);
            this.nzF.setOnClickListener(this.onClickListener);
            this.nzG.setOnClickListener(this.onClickListener);
            this.nzH.setOnClickListener(this.onClickListener);
            this.nzI.setOnClickListener(this.onClickListener);
            this.nzJ.setOnClickListener(this.onClickListener);
            this.nzJ.setOnClickListener(this.onClickListener);
            this.nzK.setOnClickListener(this.onClickListener);
            return this.bcK;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.nzu.dSh();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
