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
    private ViewGroup bbd;
    private View iZw;
    private NewUserGuideModel nEK;
    private NewUserGuideActivity nFa;
    private TbImageView nFh;
    private TbImageView nFi;
    private TbImageView nFj;
    private TbImageView nFk;
    private TbImageView nFl;
    private TbImageView nFm;
    private TbImageView nFn;
    private TbImageView nFo;
    private TbImageView nFp;
    private TbImageView nFq;
    private Button nFr;
    private final Hashtable<Integer, TbImageView> nFg = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean nFs = false;
    private boolean nFt = true;
    private final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.nFr) {
                    if (NewUserGuideMainFragment.this.nFa.dQE()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.nFa.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.nFa.finish();
                }
            } else if (NewUserGuideMainFragment.this.nFt) {
                NewUserGuideMainFragment.this.nFt = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.nFa, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dQL() {
                        NewUserGuideMainFragment.this.iZw.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.iZw.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.nFt = true;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void dQL();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.nFs = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nFa = (NewUserGuideActivity) getBaseFragmentActivity();
        this.nEK = this.nFa.dQG();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.nEK != null && !this.nFs) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.nFa.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.nEK.dQN());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.nFg.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.bbd = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.iZw = this.bbd.findViewById(R.id.root_main_view_cover);
            this.nFh = (TbImageView) this.bbd.findViewById(R.id.icon_1);
            this.nFi = (TbImageView) this.bbd.findViewById(R.id.icon_2);
            this.nFj = (TbImageView) this.bbd.findViewById(R.id.icon_3);
            this.nFk = (TbImageView) this.bbd.findViewById(R.id.icon_4);
            this.nFl = (TbImageView) this.bbd.findViewById(R.id.icon_5);
            this.nFm = (TbImageView) this.bbd.findViewById(R.id.icon_6);
            this.nFn = (TbImageView) this.bbd.findViewById(R.id.icon_7);
            this.nFo = (TbImageView) this.bbd.findViewById(R.id.icon_8);
            this.nFp = (TbImageView) this.bbd.findViewById(R.id.icon_9);
            this.nFq = (TbImageView) this.bbd.findViewById(R.id.icon_10);
            this.nFr = (Button) this.bbd.findViewById(R.id.btn_next);
            this.nFg.put(1, this.nFh);
            this.nFg.put(2, this.nFi);
            this.nFg.put(3, this.nFj);
            this.nFg.put(4, this.nFk);
            this.nFg.put(5, this.nFl);
            this.nFg.put(6, this.nFm);
            this.nFg.put(7, this.nFn);
            this.nFg.put(8, this.nFo);
            this.nFg.put(9, this.nFp);
            this.nFg.put(10, this.nFq);
            this.nFr.setOnClickListener(this.onClickListener);
            this.nFh.setOnClickListener(this.onClickListener);
            this.nFi.setOnClickListener(this.onClickListener);
            this.nFj.setOnClickListener(this.onClickListener);
            this.nFk.setOnClickListener(this.onClickListener);
            this.nFl.setOnClickListener(this.onClickListener);
            this.nFm.setOnClickListener(this.onClickListener);
            this.nFn.setOnClickListener(this.onClickListener);
            this.nFo.setOnClickListener(this.onClickListener);
            this.nFp.setOnClickListener(this.onClickListener);
            this.nFp.setOnClickListener(this.onClickListener);
            this.nFq.setOnClickListener(this.onClickListener);
            return this.bbd;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.nFa.dQI();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
