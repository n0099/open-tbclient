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
public class f extends BaseFragment {
    private View dyI;
    private NewUserGuideActivity hgA;
    private TbImageView hgH;
    private TbImageView hgI;
    private TbImageView hgJ;
    private TbImageView hgK;
    private TbImageView hgL;
    private TbImageView hgM;
    private TbImageView hgN;
    private TbImageView hgO;
    private TbImageView hgP;
    private TbImageView hgQ;
    private Button hgR;
    private NewUserGuideModel hgf;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> hgG = new Hashtable<>();
    private boolean hgh = false;
    private boolean hgS = false;
    private boolean hgT = true;
    private final View.OnClickListener blT = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == f.this.hgR) {
                    if (f.this.hgA.bzd()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    f.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(f.this.hgA.getPageContext().getPageActivity()).createNewUserCfg(1, f.this.hgh)));
                    f.this.hgA.finish();
                }
            } else if (f.this.hgT) {
                f.this.hgT = false;
                TiebaStatic.log("newUserInterestSelect");
                i iVar = new i(f.this.hgA, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.f.a
                    public void bzl() {
                        f.this.dyI.setVisibility(8);
                    }
                });
                f.this.dyI.setVisibility(0);
                iVar.show();
                f.this.hgT = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bzl();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.hgS = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hgA = (NewUserGuideActivity) getBaseFragmentActivity();
        this.hgf = this.hgA.bzf();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.hgf != null && !this.hgS) {
            if (bundle != null) {
                this.hgh = bundle.getBoolean("is_new_user");
            } else {
                this.hgh = this.hgA.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.hgf.bzn());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.hgG.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.dyI = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.hgH = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.hgI = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.hgJ = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.hgK = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.hgL = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.hgM = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.hgN = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.hgO = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.hgP = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.hgQ = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.hgR = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.hgG.put(1, this.hgH);
            this.hgG.put(2, this.hgI);
            this.hgG.put(3, this.hgJ);
            this.hgG.put(4, this.hgK);
            this.hgG.put(5, this.hgL);
            this.hgG.put(6, this.hgM);
            this.hgG.put(7, this.hgN);
            this.hgG.put(8, this.hgO);
            this.hgG.put(9, this.hgP);
            this.hgG.put(10, this.hgQ);
            this.hgR.setOnClickListener(this.blT);
            this.hgH.setOnClickListener(this.blT);
            this.hgI.setOnClickListener(this.blT);
            this.hgJ.setOnClickListener(this.blT);
            this.hgK.setOnClickListener(this.blT);
            this.hgL.setOnClickListener(this.blT);
            this.hgM.setOnClickListener(this.blT);
            this.hgN.setOnClickListener(this.blT);
            this.hgO.setOnClickListener(this.blT);
            this.hgP.setOnClickListener(this.blT);
            this.hgP.setOnClickListener(this.blT);
            this.hgQ.setOnClickListener(this.blT);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.hgA.bzh();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
