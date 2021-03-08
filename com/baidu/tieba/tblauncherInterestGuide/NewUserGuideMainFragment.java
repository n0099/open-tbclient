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
    private ViewGroup bcD;
    private View jbf;
    private NewUserGuideModel nGQ;
    private NewUserGuideActivity nHg;
    private TbImageView nHn;
    private TbImageView nHo;
    private TbImageView nHp;
    private TbImageView nHq;
    private TbImageView nHr;
    private TbImageView nHs;
    private TbImageView nHt;
    private TbImageView nHu;
    private TbImageView nHv;
    private TbImageView nHw;
    private Button nHx;
    private final Hashtable<Integer, TbImageView> nHm = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean nHy = false;
    private boolean nHz = true;
    private final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.nHx) {
                    if (NewUserGuideMainFragment.this.nHg.dQN()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.nHg.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.nHg.finish();
                }
            } else if (NewUserGuideMainFragment.this.nHz) {
                NewUserGuideMainFragment.this.nHz = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.nHg, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dQU() {
                        NewUserGuideMainFragment.this.jbf.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.jbf.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.nHz = true;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void dQU();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.nHy = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nHg = (NewUserGuideActivity) getBaseFragmentActivity();
        this.nGQ = this.nHg.dQP();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.nGQ != null && !this.nHy) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.nHg.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.nGQ.dQW());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.nHm.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.bcD = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.jbf = this.bcD.findViewById(R.id.root_main_view_cover);
            this.nHn = (TbImageView) this.bcD.findViewById(R.id.icon_1);
            this.nHo = (TbImageView) this.bcD.findViewById(R.id.icon_2);
            this.nHp = (TbImageView) this.bcD.findViewById(R.id.icon_3);
            this.nHq = (TbImageView) this.bcD.findViewById(R.id.icon_4);
            this.nHr = (TbImageView) this.bcD.findViewById(R.id.icon_5);
            this.nHs = (TbImageView) this.bcD.findViewById(R.id.icon_6);
            this.nHt = (TbImageView) this.bcD.findViewById(R.id.icon_7);
            this.nHu = (TbImageView) this.bcD.findViewById(R.id.icon_8);
            this.nHv = (TbImageView) this.bcD.findViewById(R.id.icon_9);
            this.nHw = (TbImageView) this.bcD.findViewById(R.id.icon_10);
            this.nHx = (Button) this.bcD.findViewById(R.id.btn_next);
            this.nHm.put(1, this.nHn);
            this.nHm.put(2, this.nHo);
            this.nHm.put(3, this.nHp);
            this.nHm.put(4, this.nHq);
            this.nHm.put(5, this.nHr);
            this.nHm.put(6, this.nHs);
            this.nHm.put(7, this.nHt);
            this.nHm.put(8, this.nHu);
            this.nHm.put(9, this.nHv);
            this.nHm.put(10, this.nHw);
            this.nHx.setOnClickListener(this.onClickListener);
            this.nHn.setOnClickListener(this.onClickListener);
            this.nHo.setOnClickListener(this.onClickListener);
            this.nHp.setOnClickListener(this.onClickListener);
            this.nHq.setOnClickListener(this.onClickListener);
            this.nHr.setOnClickListener(this.onClickListener);
            this.nHs.setOnClickListener(this.onClickListener);
            this.nHt.setOnClickListener(this.onClickListener);
            this.nHu.setOnClickListener(this.onClickListener);
            this.nHv.setOnClickListener(this.onClickListener);
            this.nHv.setOnClickListener(this.onClickListener);
            this.nHw.setOnClickListener(this.onClickListener);
            return this.bcD;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.nHg.dQR();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
