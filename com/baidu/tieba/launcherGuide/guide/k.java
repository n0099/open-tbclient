package com.baidu.tieba.launcherGuide.guide;

import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class k extends BaseFragment {
    private com.baidu.tieba.launcherGuide.a.a chV;
    private ViewGroup ciC;
    private View ciD;
    private TbImageView ciE;
    private TbImageView ciF;
    private TbImageView ciG;
    private TbImageView ciH;
    private TbImageView ciI;
    private TbImageView ciJ;
    private TbImageView ciK;
    private TbImageView ciL;
    private TbImageView ciM;
    private TbImageView ciN;
    private NewUserGuideActivity ciw;
    private Button mNext;
    private final Hashtable<Integer, TbImageView> ciO = new Hashtable<>();
    private boolean chX = false;
    private boolean ciP = false;
    private boolean ciQ = true;
    private final View.OnClickListener alr = new l(this);

    /* loaded from: classes.dex */
    public interface a {
        void aeB();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.ciP = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ciw = (NewUserGuideActivity) getBaseFragmentActivity();
        this.chV = this.ciw.aev();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.chV != null && !this.ciP) {
            if (bundle != null) {
                this.chX = bundle.getBoolean("is_new_user");
            } else {
                this.chX = this.ciw.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.chV.aeD());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.ciO.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.d(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.ciC = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(n.g.guide_main, (ViewGroup) null);
            this.ciD = this.ciC.findViewById(n.f.root_main_view_cover);
            this.ciE = (TbImageView) this.ciC.findViewById(n.f.icon_1);
            this.ciF = (TbImageView) this.ciC.findViewById(n.f.icon_2);
            this.ciG = (TbImageView) this.ciC.findViewById(n.f.icon_3);
            this.ciH = (TbImageView) this.ciC.findViewById(n.f.icon_4);
            this.ciI = (TbImageView) this.ciC.findViewById(n.f.icon_5);
            this.ciJ = (TbImageView) this.ciC.findViewById(n.f.icon_6);
            this.ciK = (TbImageView) this.ciC.findViewById(n.f.icon_7);
            this.ciL = (TbImageView) this.ciC.findViewById(n.f.icon_8);
            this.ciM = (TbImageView) this.ciC.findViewById(n.f.icon_9);
            this.ciN = (TbImageView) this.ciC.findViewById(n.f.icon_10);
            this.mNext = (Button) this.ciC.findViewById(n.f.btn_next);
            this.ciO.put(1, this.ciE);
            this.ciO.put(2, this.ciF);
            this.ciO.put(3, this.ciG);
            this.ciO.put(4, this.ciH);
            this.ciO.put(5, this.ciI);
            this.ciO.put(6, this.ciJ);
            this.ciO.put(7, this.ciK);
            this.ciO.put(8, this.ciL);
            this.ciO.put(9, this.ciM);
            this.ciO.put(10, this.ciN);
            this.mNext.setOnClickListener(this.alr);
            this.ciE.setOnClickListener(this.alr);
            this.ciF.setOnClickListener(this.alr);
            this.ciG.setOnClickListener(this.alr);
            this.ciH.setOnClickListener(this.alr);
            this.ciI.setOnClickListener(this.alr);
            this.ciJ.setOnClickListener(this.alr);
            this.ciK.setOnClickListener(this.alr);
            this.ciL.setOnClickListener(this.alr);
            this.ciM.setOnClickListener(this.alr);
            this.ciM.setOnClickListener(this.alr);
            this.ciN.setOnClickListener(this.alr);
            return this.ciC;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.ciw.aex();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
