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
/* loaded from: classes22.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View ihT;
    private NewUserGuideActivity mLM;
    private TbImageView mLT;
    private TbImageView mLU;
    private TbImageView mLV;
    private TbImageView mLW;
    private TbImageView mLX;
    private TbImageView mLY;
    private TbImageView mLZ;
    private NewUserGuideModel mLu;
    private TbImageView mMa;
    private TbImageView mMb;
    private TbImageView mMc;
    private Button mMd;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> mLS = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean mMe = false;
    private boolean mMf = true;
    private final View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.mMd) {
                    if (NewUserGuideMainFragment.this.mLM.dGP()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.mLM.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.mLM.finish();
                }
            } else if (NewUserGuideMainFragment.this.mMf) {
                NewUserGuideMainFragment.this.mMf = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.mLM, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dGW() {
                        NewUserGuideMainFragment.this.ihT.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.ihT.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.mMf = true;
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void dGW();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.mMe = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mLM = (NewUserGuideActivity) getBaseFragmentActivity();
        this.mLu = this.mLM.dGR();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.mLu != null && !this.mMe) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.mLM.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.mLu.dGY());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.mLS.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.ihT = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.mLT = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.mLU = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.mLV = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.mLW = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.mLX = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.mLY = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.mLZ = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.mMa = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.mMb = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.mMc = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.mMd = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.mLS.put(1, this.mLT);
            this.mLS.put(2, this.mLU);
            this.mLS.put(3, this.mLV);
            this.mLS.put(4, this.mLW);
            this.mLS.put(5, this.mLX);
            this.mLS.put(6, this.mLY);
            this.mLS.put(7, this.mLZ);
            this.mLS.put(8, this.mMa);
            this.mLS.put(9, this.mMb);
            this.mLS.put(10, this.mMc);
            this.mMd.setOnClickListener(this.eTU);
            this.mLT.setOnClickListener(this.eTU);
            this.mLU.setOnClickListener(this.eTU);
            this.mLV.setOnClickListener(this.eTU);
            this.mLW.setOnClickListener(this.eTU);
            this.mLX.setOnClickListener(this.eTU);
            this.mLY.setOnClickListener(this.eTU);
            this.mLZ.setOnClickListener(this.eTU);
            this.mMa.setOnClickListener(this.eTU);
            this.mMb.setOnClickListener(this.eTU);
            this.mMb.setOnClickListener(this.eTU);
            this.mMc.setOnClickListener(this.eTU);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.mLM.dGT();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
