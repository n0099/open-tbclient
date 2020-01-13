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
/* loaded from: classes7.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View gfv;
    private NewUserGuideActivity kmB;
    private TbImageView kmI;
    private TbImageView kmJ;
    private TbImageView kmK;
    private TbImageView kmL;
    private TbImageView kmM;
    private TbImageView kmN;
    private TbImageView kmO;
    private TbImageView kmP;
    private TbImageView kmQ;
    private TbImageView kmR;
    private Button kmS;
    private NewUserGuideModel kmj;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> kmH = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean kmT = false;
    private boolean kmU = true;
    private final View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.kmS) {
                    if (NewUserGuideMainFragment.this.kmB.cLR()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.kmB.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.kmB.finish();
                }
            } else if (NewUserGuideMainFragment.this.kmU) {
                NewUserGuideMainFragment.this.kmU = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.kmB, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cLY() {
                        NewUserGuideMainFragment.this.gfv.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.gfv.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.kmU = true;
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void cLY();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.kmT = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kmB = (NewUserGuideActivity) getBaseFragmentActivity();
        this.kmj = this.kmB.cLT();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.kmj != null && !this.kmT) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.kmB.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.kmj.cMa());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.kmH.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.gfv = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.kmI = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.kmJ = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.kmK = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.kmL = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.kmM = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.kmN = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.kmO = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.kmP = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.kmQ = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.kmR = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.kmS = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.kmH.put(1, this.kmI);
            this.kmH.put(2, this.kmJ);
            this.kmH.put(3, this.kmK);
            this.kmH.put(4, this.kmL);
            this.kmH.put(5, this.kmM);
            this.kmH.put(6, this.kmN);
            this.kmH.put(7, this.kmO);
            this.kmH.put(8, this.kmP);
            this.kmH.put(9, this.kmQ);
            this.kmH.put(10, this.kmR);
            this.kmS.setOnClickListener(this.dmY);
            this.kmI.setOnClickListener(this.dmY);
            this.kmJ.setOnClickListener(this.dmY);
            this.kmK.setOnClickListener(this.dmY);
            this.kmL.setOnClickListener(this.dmY);
            this.kmM.setOnClickListener(this.dmY);
            this.kmN.setOnClickListener(this.dmY);
            this.kmO.setOnClickListener(this.dmY);
            this.kmP.setOnClickListener(this.dmY);
            this.kmQ.setOnClickListener(this.dmY);
            this.kmQ.setOnClickListener(this.dmY);
            this.kmR.setOnClickListener(this.dmY);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.kmB.cLV();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
