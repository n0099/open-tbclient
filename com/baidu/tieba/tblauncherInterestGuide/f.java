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
    private View dyR;
    private NewUserGuideModel hfW;
    private TbImageView hgA;
    private TbImageView hgB;
    private TbImageView hgC;
    private TbImageView hgD;
    private TbImageView hgE;
    private TbImageView hgF;
    private TbImageView hgG;
    private TbImageView hgH;
    private Button hgI;
    private NewUserGuideActivity hgr;
    private TbImageView hgy;
    private TbImageView hgz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> hgx = new Hashtable<>();
    private boolean hfY = false;
    private boolean hgJ = false;
    private boolean hgK = true;
    private final View.OnClickListener bmd = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == f.this.hgI) {
                    if (f.this.hgr.byZ()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    f.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(f.this.hgr.getPageContext().getPageActivity()).createNewUserCfg(1, f.this.hfY)));
                    f.this.hgr.finish();
                }
            } else if (f.this.hgK) {
                f.this.hgK = false;
                TiebaStatic.log("newUserInterestSelect");
                i iVar = new i(f.this.hgr, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.f.a
                    public void bzh() {
                        f.this.dyR.setVisibility(8);
                    }
                });
                f.this.dyR.setVisibility(0);
                iVar.show();
                f.this.hgK = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bzh();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.hgJ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hgr = (NewUserGuideActivity) getBaseFragmentActivity();
        this.hfW = this.hgr.bzb();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.hfW != null && !this.hgJ) {
            if (bundle != null) {
                this.hfY = bundle.getBoolean("is_new_user");
            } else {
                this.hfY = this.hgr.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.hfW.bzj());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.hgx.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.dyR = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.hgy = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.hgz = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.hgA = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.hgB = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.hgC = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.hgD = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.hgE = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.hgF = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.hgG = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.hgH = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.hgI = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.hgx.put(1, this.hgy);
            this.hgx.put(2, this.hgz);
            this.hgx.put(3, this.hgA);
            this.hgx.put(4, this.hgB);
            this.hgx.put(5, this.hgC);
            this.hgx.put(6, this.hgD);
            this.hgx.put(7, this.hgE);
            this.hgx.put(8, this.hgF);
            this.hgx.put(9, this.hgG);
            this.hgx.put(10, this.hgH);
            this.hgI.setOnClickListener(this.bmd);
            this.hgy.setOnClickListener(this.bmd);
            this.hgz.setOnClickListener(this.bmd);
            this.hgA.setOnClickListener(this.bmd);
            this.hgB.setOnClickListener(this.bmd);
            this.hgC.setOnClickListener(this.bmd);
            this.hgD.setOnClickListener(this.bmd);
            this.hgE.setOnClickListener(this.bmd);
            this.hgF.setOnClickListener(this.bmd);
            this.hgG.setOnClickListener(this.bmd);
            this.hgG.setOnClickListener(this.bmd);
            this.hgH.setOnClickListener(this.bmd);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.hgr.bzd();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
