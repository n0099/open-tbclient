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
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class k extends BaseFragment {
    private NewUserGuideActivity bRD;
    private ViewGroup bRJ;
    private View bRK;
    private TbImageView bRL;
    private TbImageView bRM;
    private TbImageView bRN;
    private TbImageView bRO;
    private TbImageView bRP;
    private TbImageView bRQ;
    private TbImageView bRR;
    private TbImageView bRS;
    private TbImageView bRT;
    private TbImageView bRU;
    private com.baidu.tieba.launcherGuide.a.a bRd;
    private Button mNext;
    private final Hashtable<Integer, TbImageView> bRV = new Hashtable<>();
    private boolean bRf = false;
    private boolean bRW = false;
    private boolean bRX = true;
    private final View.OnClickListener ajA = new l(this);

    /* loaded from: classes.dex */
    public interface a {
        void aaE();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.bRW = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bRD = (NewUserGuideActivity) getBaseFragmentActivity();
        this.bRd = this.bRD.aay();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.bRd != null && !this.bRW) {
            if (bundle != null) {
                this.bRf = bundle.getBoolean("is_new_user");
            } else {
                this.bRf = this.bRD.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.bRd.aaG());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.bRV.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.d(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.bRJ = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(i.g.guide_main, (ViewGroup) null);
            this.bRK = this.bRJ.findViewById(i.f.root_main_view_cover);
            this.bRL = (TbImageView) this.bRJ.findViewById(i.f.icon_1);
            this.bRM = (TbImageView) this.bRJ.findViewById(i.f.icon_2);
            this.bRN = (TbImageView) this.bRJ.findViewById(i.f.icon_3);
            this.bRO = (TbImageView) this.bRJ.findViewById(i.f.icon_4);
            this.bRP = (TbImageView) this.bRJ.findViewById(i.f.icon_5);
            this.bRQ = (TbImageView) this.bRJ.findViewById(i.f.icon_6);
            this.bRR = (TbImageView) this.bRJ.findViewById(i.f.icon_7);
            this.bRS = (TbImageView) this.bRJ.findViewById(i.f.icon_8);
            this.bRT = (TbImageView) this.bRJ.findViewById(i.f.icon_9);
            this.bRU = (TbImageView) this.bRJ.findViewById(i.f.icon_10);
            this.mNext = (Button) this.bRJ.findViewById(i.f.btn_next);
            this.bRV.put(1, this.bRL);
            this.bRV.put(2, this.bRM);
            this.bRV.put(3, this.bRN);
            this.bRV.put(4, this.bRO);
            this.bRV.put(5, this.bRP);
            this.bRV.put(6, this.bRQ);
            this.bRV.put(7, this.bRR);
            this.bRV.put(8, this.bRS);
            this.bRV.put(9, this.bRT);
            this.bRV.put(10, this.bRU);
            this.mNext.setOnClickListener(this.ajA);
            this.bRL.setOnClickListener(this.ajA);
            this.bRM.setOnClickListener(this.ajA);
            this.bRN.setOnClickListener(this.ajA);
            this.bRO.setOnClickListener(this.ajA);
            this.bRP.setOnClickListener(this.ajA);
            this.bRQ.setOnClickListener(this.ajA);
            this.bRR.setOnClickListener(this.ajA);
            this.bRS.setOnClickListener(this.ajA);
            this.bRT.setOnClickListener(this.ajA);
            this.bRT.setOnClickListener(this.ajA);
            this.bRU.setOnClickListener(this.ajA);
            return this.bRJ;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.bRD.aaA();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
