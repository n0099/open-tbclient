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
    private View dyF;
    private NewUserGuideModel hfH;
    private NewUserGuideActivity hgc;
    private TbImageView hgj;
    private TbImageView hgk;
    private TbImageView hgl;
    private TbImageView hgm;
    private TbImageView hgn;
    private TbImageView hgo;
    private TbImageView hgp;
    private TbImageView hgq;
    private TbImageView hgr;
    private TbImageView hgs;
    private Button hgt;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> hgi = new Hashtable<>();
    private boolean hfJ = false;
    private boolean hgu = false;
    private boolean hgv = true;
    private final View.OnClickListener blQ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == f.this.hgt) {
                    if (f.this.hgc.byY()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    f.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(f.this.hgc.getPageContext().getPageActivity()).createNewUserCfg(1, f.this.hfJ)));
                    f.this.hgc.finish();
                }
            } else if (f.this.hgv) {
                f.this.hgv = false;
                TiebaStatic.log("newUserInterestSelect");
                i iVar = new i(f.this.hgc, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.f.a
                    public void bzg() {
                        f.this.dyF.setVisibility(8);
                    }
                });
                f.this.dyF.setVisibility(0);
                iVar.show();
                f.this.hgv = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bzg();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.hgu = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hgc = (NewUserGuideActivity) getBaseFragmentActivity();
        this.hfH = this.hgc.bza();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.hfH != null && !this.hgu) {
            if (bundle != null) {
                this.hfJ = bundle.getBoolean("is_new_user");
            } else {
                this.hfJ = this.hgc.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.hfH.bzi());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.hgi.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.dyF = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.hgj = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.hgk = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.hgl = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.hgm = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.hgn = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.hgo = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.hgp = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.hgq = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.hgr = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.hgs = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.hgt = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.hgi.put(1, this.hgj);
            this.hgi.put(2, this.hgk);
            this.hgi.put(3, this.hgl);
            this.hgi.put(4, this.hgm);
            this.hgi.put(5, this.hgn);
            this.hgi.put(6, this.hgo);
            this.hgi.put(7, this.hgp);
            this.hgi.put(8, this.hgq);
            this.hgi.put(9, this.hgr);
            this.hgi.put(10, this.hgs);
            this.hgt.setOnClickListener(this.blQ);
            this.hgj.setOnClickListener(this.blQ);
            this.hgk.setOnClickListener(this.blQ);
            this.hgl.setOnClickListener(this.blQ);
            this.hgm.setOnClickListener(this.blQ);
            this.hgn.setOnClickListener(this.blQ);
            this.hgo.setOnClickListener(this.blQ);
            this.hgp.setOnClickListener(this.blQ);
            this.hgq.setOnClickListener(this.blQ);
            this.hgr.setOnClickListener(this.blQ);
            this.hgr.setOnClickListener(this.blQ);
            this.hgs.setOnClickListener(this.blQ);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.hgc.bzc();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
