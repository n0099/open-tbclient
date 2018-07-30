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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes3.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View dcz;
    private NewUserGuideModel gTL;
    private NewUserGuideActivity gUg;
    private TbImageView gUn;
    private TbImageView gUo;
    private TbImageView gUp;
    private TbImageView gUq;
    private TbImageView gUr;
    private TbImageView gUs;
    private TbImageView gUt;
    private TbImageView gUu;
    private TbImageView gUv;
    private TbImageView gUw;
    private Button gUx;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> gUm = new Hashtable<>();
    private boolean gTN = false;
    private boolean gUy = false;
    private boolean gUz = true;
    private final View.OnClickListener aGU = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.gUx) {
                    if (NewUserGuideMainFragment.this.gUg.byr()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.gUg.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.gTN)));
                    NewUserGuideMainFragment.this.gUg.finish();
                }
            } else if (NewUserGuideMainFragment.this.gUz) {
                NewUserGuideMainFragment.this.gUz = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.gUg, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void byz() {
                        NewUserGuideMainFragment.this.dcz.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.dcz.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.gUz = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void byz();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.gUy = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUg = (NewUserGuideActivity) getBaseFragmentActivity();
        this.gTL = this.gUg.byt();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.gTL != null && !this.gUy) {
            if (bundle != null) {
                this.gTN = bundle.getBoolean("is_new_user");
            } else {
                this.gTN = this.gUg.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.gTL.byB());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.gUm.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(d.h.guide_main, (ViewGroup) null);
            this.dcz = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.gUn = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.gUo = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.gUp = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.gUq = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.gUr = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.gUs = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.gUt = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.gUu = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.gUv = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.gUw = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.gUx = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.gUm.put(1, this.gUn);
            this.gUm.put(2, this.gUo);
            this.gUm.put(3, this.gUp);
            this.gUm.put(4, this.gUq);
            this.gUm.put(5, this.gUr);
            this.gUm.put(6, this.gUs);
            this.gUm.put(7, this.gUt);
            this.gUm.put(8, this.gUu);
            this.gUm.put(9, this.gUv);
            this.gUm.put(10, this.gUw);
            this.gUx.setOnClickListener(this.aGU);
            this.gUn.setOnClickListener(this.aGU);
            this.gUo.setOnClickListener(this.aGU);
            this.gUp.setOnClickListener(this.aGU);
            this.gUq.setOnClickListener(this.aGU);
            this.gUr.setOnClickListener(this.aGU);
            this.gUs.setOnClickListener(this.aGU);
            this.gUt.setOnClickListener(this.aGU);
            this.gUu.setOnClickListener(this.aGU);
            this.gUv.setOnClickListener(this.aGU);
            this.gUv.setOnClickListener(this.aGU);
            this.gUw.setOnClickListener(this.aGU);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.gUg.byv();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
