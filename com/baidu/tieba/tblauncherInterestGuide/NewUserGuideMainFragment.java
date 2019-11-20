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
/* loaded from: classes4.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private ViewGroup YW;
    private View fnO;
    private NewUserGuideActivity joM;
    private TbImageView joT;
    private TbImageView joU;
    private TbImageView joV;
    private TbImageView joW;
    private TbImageView joX;
    private TbImageView joY;
    private TbImageView joZ;
    private NewUserGuideModel jou;
    private TbImageView jpa;
    private TbImageView jpb;
    private TbImageView jpc;
    private Button jpd;
    private final Hashtable<Integer, TbImageView> joS = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean jpe = false;
    private boolean jpf = true;
    private final View.OnClickListener cze = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.jpd) {
                    if (NewUserGuideMainFragment.this.joM.cqH()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.joM.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.joM.finish();
                }
            } else if (NewUserGuideMainFragment.this.jpf) {
                NewUserGuideMainFragment.this.jpf = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.joM, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cqO() {
                        NewUserGuideMainFragment.this.fnO.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.fnO.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.jpf = true;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void cqO();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.jpe = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.joM = (NewUserGuideActivity) getBaseFragmentActivity();
        this.jou = this.joM.cqJ();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.jou != null && !this.jpe) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.joM.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.jou.cqQ());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.joS.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.YW = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.fnO = this.YW.findViewById(R.id.root_main_view_cover);
            this.joT = (TbImageView) this.YW.findViewById(R.id.icon_1);
            this.joU = (TbImageView) this.YW.findViewById(R.id.icon_2);
            this.joV = (TbImageView) this.YW.findViewById(R.id.icon_3);
            this.joW = (TbImageView) this.YW.findViewById(R.id.icon_4);
            this.joX = (TbImageView) this.YW.findViewById(R.id.icon_5);
            this.joY = (TbImageView) this.YW.findViewById(R.id.icon_6);
            this.joZ = (TbImageView) this.YW.findViewById(R.id.icon_7);
            this.jpa = (TbImageView) this.YW.findViewById(R.id.icon_8);
            this.jpb = (TbImageView) this.YW.findViewById(R.id.icon_9);
            this.jpc = (TbImageView) this.YW.findViewById(R.id.icon_10);
            this.jpd = (Button) this.YW.findViewById(R.id.btn_next);
            this.joS.put(1, this.joT);
            this.joS.put(2, this.joU);
            this.joS.put(3, this.joV);
            this.joS.put(4, this.joW);
            this.joS.put(5, this.joX);
            this.joS.put(6, this.joY);
            this.joS.put(7, this.joZ);
            this.joS.put(8, this.jpa);
            this.joS.put(9, this.jpb);
            this.joS.put(10, this.jpc);
            this.jpd.setOnClickListener(this.cze);
            this.joT.setOnClickListener(this.cze);
            this.joU.setOnClickListener(this.cze);
            this.joV.setOnClickListener(this.cze);
            this.joW.setOnClickListener(this.cze);
            this.joX.setOnClickListener(this.cze);
            this.joY.setOnClickListener(this.cze);
            this.joZ.setOnClickListener(this.cze);
            this.jpa.setOnClickListener(this.cze);
            this.jpb.setOnClickListener(this.cze);
            this.jpb.setOnClickListener(this.cze);
            this.jpc.setOnClickListener(this.cze);
            return this.YW;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.joM.cqL();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
