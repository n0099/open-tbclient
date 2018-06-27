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
    private View cZH;
    private NewUserGuideModel gSN;
    private NewUserGuideActivity gTi;
    private TbImageView gTp;
    private TbImageView gTq;
    private TbImageView gTr;
    private TbImageView gTs;
    private TbImageView gTt;
    private TbImageView gTu;
    private TbImageView gTv;
    private TbImageView gTw;
    private TbImageView gTx;
    private TbImageView gTy;
    private Button gTz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> gTo = new Hashtable<>();
    private boolean gSP = false;
    private boolean gTA = false;
    private boolean gTB = true;
    private final View.OnClickListener aGU = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.gTz) {
                    if (NewUserGuideMainFragment.this.gTi.bzO()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.gTi.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.gSP)));
                    NewUserGuideMainFragment.this.gTi.finish();
                }
            } else if (NewUserGuideMainFragment.this.gTB) {
                NewUserGuideMainFragment.this.gTB = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.gTi, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bzW() {
                        NewUserGuideMainFragment.this.cZH.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.cZH.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.gTB = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bzW();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.gTA = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gTi = (NewUserGuideActivity) getBaseFragmentActivity();
        this.gSN = this.gTi.bzQ();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.gSN != null && !this.gTA) {
            if (bundle != null) {
                this.gSP = bundle.getBoolean("is_new_user");
            } else {
                this.gSP = this.gTi.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.gSN.bzY());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.gTo.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(d.i.guide_main, (ViewGroup) null);
            this.cZH = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.gTp = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.gTq = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.gTr = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.gTs = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.gTt = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.gTu = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.gTv = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.gTw = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.gTx = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.gTy = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.gTz = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.gTo.put(1, this.gTp);
            this.gTo.put(2, this.gTq);
            this.gTo.put(3, this.gTr);
            this.gTo.put(4, this.gTs);
            this.gTo.put(5, this.gTt);
            this.gTo.put(6, this.gTu);
            this.gTo.put(7, this.gTv);
            this.gTo.put(8, this.gTw);
            this.gTo.put(9, this.gTx);
            this.gTo.put(10, this.gTy);
            this.gTz.setOnClickListener(this.aGU);
            this.gTp.setOnClickListener(this.aGU);
            this.gTq.setOnClickListener(this.aGU);
            this.gTr.setOnClickListener(this.aGU);
            this.gTs.setOnClickListener(this.aGU);
            this.gTt.setOnClickListener(this.aGU);
            this.gTu.setOnClickListener(this.aGU);
            this.gTv.setOnClickListener(this.aGU);
            this.gTw.setOnClickListener(this.aGU);
            this.gTx.setOnClickListener(this.aGU);
            this.gTx.setOnClickListener(this.aGU);
            this.gTy.setOnClickListener(this.aGU);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.gTi.bzS();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
