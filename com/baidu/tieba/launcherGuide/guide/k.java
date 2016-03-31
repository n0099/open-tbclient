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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class k extends BaseFragment {
    private ViewGroup bKV;
    private NewUserGuideActivity cDG;
    private View cDM;
    private TbImageView cDN;
    private TbImageView cDO;
    private TbImageView cDP;
    private TbImageView cDQ;
    private TbImageView cDR;
    private TbImageView cDS;
    private TbImageView cDT;
    private TbImageView cDU;
    private TbImageView cDV;
    private TbImageView cDW;
    private Button cDY;
    private com.baidu.tieba.launcherGuide.a.a cDg;
    private final Hashtable<Integer, TbImageView> cDX = new Hashtable<>();
    private boolean cDi = false;
    private boolean cDZ = false;
    private boolean cEa = true;
    private final View.OnClickListener anH = new l(this);

    /* loaded from: classes.dex */
    public interface a {
        void anf();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.cDZ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cDG = (NewUserGuideActivity) getBaseFragmentActivity();
        this.cDg = this.cDG.amZ();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.cDg != null && !this.cDZ) {
            if (bundle != null) {
                this.cDi = bundle.getBoolean("is_new_user");
            } else {
                this.cDi = this.cDG.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.cDg.anh());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.cDX.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.c(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.bKV = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(t.h.guide_main, (ViewGroup) null);
            this.cDM = this.bKV.findViewById(t.g.root_main_view_cover);
            this.cDN = (TbImageView) this.bKV.findViewById(t.g.icon_1);
            this.cDO = (TbImageView) this.bKV.findViewById(t.g.icon_2);
            this.cDP = (TbImageView) this.bKV.findViewById(t.g.icon_3);
            this.cDQ = (TbImageView) this.bKV.findViewById(t.g.icon_4);
            this.cDR = (TbImageView) this.bKV.findViewById(t.g.icon_5);
            this.cDS = (TbImageView) this.bKV.findViewById(t.g.icon_6);
            this.cDT = (TbImageView) this.bKV.findViewById(t.g.icon_7);
            this.cDU = (TbImageView) this.bKV.findViewById(t.g.icon_8);
            this.cDV = (TbImageView) this.bKV.findViewById(t.g.icon_9);
            this.cDW = (TbImageView) this.bKV.findViewById(t.g.icon_10);
            this.cDY = (Button) this.bKV.findViewById(t.g.btn_next);
            this.cDX.put(1, this.cDN);
            this.cDX.put(2, this.cDO);
            this.cDX.put(3, this.cDP);
            this.cDX.put(4, this.cDQ);
            this.cDX.put(5, this.cDR);
            this.cDX.put(6, this.cDS);
            this.cDX.put(7, this.cDT);
            this.cDX.put(8, this.cDU);
            this.cDX.put(9, this.cDV);
            this.cDX.put(10, this.cDW);
            this.cDY.setOnClickListener(this.anH);
            this.cDN.setOnClickListener(this.anH);
            this.cDO.setOnClickListener(this.anH);
            this.cDP.setOnClickListener(this.anH);
            this.cDQ.setOnClickListener(this.anH);
            this.cDR.setOnClickListener(this.anH);
            this.cDS.setOnClickListener(this.anH);
            this.cDT.setOnClickListener(this.anH);
            this.cDU.setOnClickListener(this.anH);
            this.cDV.setOnClickListener(this.anH);
            this.cDV.setOnClickListener(this.anH);
            this.cDW.setOnClickListener(this.anH);
            return this.bKV;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.cDG.anb();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
