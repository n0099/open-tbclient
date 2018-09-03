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
import com.baidu.tieba.f;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes3.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View dcx;
    private NewUserGuideModel gTN;
    private NewUserGuideActivity gUi;
    private TbImageView gUp;
    private TbImageView gUq;
    private TbImageView gUr;
    private TbImageView gUs;
    private TbImageView gUt;
    private TbImageView gUu;
    private TbImageView gUv;
    private TbImageView gUw;
    private TbImageView gUx;
    private TbImageView gUy;
    private Button gUz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> gUo = new Hashtable<>();
    private boolean gTP = false;
    private boolean gUA = false;
    private boolean gUB = true;
    private final View.OnClickListener aGT = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.gUz) {
                    if (NewUserGuideMainFragment.this.gUi.byt()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.gUi.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.gTP)));
                    NewUserGuideMainFragment.this.gUi.finish();
                }
            } else if (NewUserGuideMainFragment.this.gUB) {
                NewUserGuideMainFragment.this.gUB = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.gUi, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void byB() {
                        NewUserGuideMainFragment.this.dcx.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.dcx.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.gUB = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void byB();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.gUA = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUi = (NewUserGuideActivity) getBaseFragmentActivity();
        this.gTN = this.gUi.byv();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.gTN != null && !this.gUA) {
            if (bundle != null) {
                this.gTP = bundle.getBoolean("is_new_user");
            } else {
                this.gTP = this.gUi.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.gTN.byD());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.gUo.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(f.h.guide_main, (ViewGroup) null);
            this.dcx = this.mRoot.findViewById(f.g.root_main_view_cover);
            this.gUp = (TbImageView) this.mRoot.findViewById(f.g.icon_1);
            this.gUq = (TbImageView) this.mRoot.findViewById(f.g.icon_2);
            this.gUr = (TbImageView) this.mRoot.findViewById(f.g.icon_3);
            this.gUs = (TbImageView) this.mRoot.findViewById(f.g.icon_4);
            this.gUt = (TbImageView) this.mRoot.findViewById(f.g.icon_5);
            this.gUu = (TbImageView) this.mRoot.findViewById(f.g.icon_6);
            this.gUv = (TbImageView) this.mRoot.findViewById(f.g.icon_7);
            this.gUw = (TbImageView) this.mRoot.findViewById(f.g.icon_8);
            this.gUx = (TbImageView) this.mRoot.findViewById(f.g.icon_9);
            this.gUy = (TbImageView) this.mRoot.findViewById(f.g.icon_10);
            this.gUz = (Button) this.mRoot.findViewById(f.g.btn_next);
            this.gUo.put(1, this.gUp);
            this.gUo.put(2, this.gUq);
            this.gUo.put(3, this.gUr);
            this.gUo.put(4, this.gUs);
            this.gUo.put(5, this.gUt);
            this.gUo.put(6, this.gUu);
            this.gUo.put(7, this.gUv);
            this.gUo.put(8, this.gUw);
            this.gUo.put(9, this.gUx);
            this.gUo.put(10, this.gUy);
            this.gUz.setOnClickListener(this.aGT);
            this.gUp.setOnClickListener(this.aGT);
            this.gUq.setOnClickListener(this.aGT);
            this.gUr.setOnClickListener(this.aGT);
            this.gUs.setOnClickListener(this.aGT);
            this.gUt.setOnClickListener(this.aGT);
            this.gUu.setOnClickListener(this.aGT);
            this.gUv.setOnClickListener(this.aGT);
            this.gUw.setOnClickListener(this.aGT);
            this.gUx.setOnClickListener(this.aGT);
            this.gUx.setOnClickListener(this.aGT);
            this.gUy.setOnClickListener(this.aGT);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.gUi.byx();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
