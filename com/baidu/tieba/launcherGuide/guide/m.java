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
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class m extends BaseFragment {
    private NewUserGuideActivity bwE;
    private ViewGroup bwK;
    private View bwL;
    private TbImageView bwM;
    private TbImageView bwN;
    private TbImageView bwO;
    private TbImageView bwP;
    private TbImageView bwQ;
    private TbImageView bwR;
    private TbImageView bwS;
    private TbImageView bwT;
    private TbImageView bwU;
    private TbImageView bwV;
    private com.baidu.tieba.launcherGuide.a.a bwg;
    private Button mNext;
    private final Hashtable<Integer, TbImageView> bwW = new Hashtable<>();
    private boolean bwi = false;
    private boolean bwX = false;
    private boolean bwY = true;
    private final View.OnClickListener adP = new n(this);

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.bwX = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bwE = (NewUserGuideActivity) getBaseFragmentActivity();
        this.bwg = this.bwE.VZ();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.bwg != null && !this.bwX) {
            if (bundle != null) {
                this.bwi = bundle.getBoolean("is_new_user");
            } else {
                this.bwi = this.bwE.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.bwg.Wh());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.bwW.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.c(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.bwK = (ViewGroup) com.baidu.adp.lib.g.b.hH().inflate(layoutInflater.getContext(), com.baidu.tieba.w.guide_main, null);
            this.bwL = this.bwK.findViewById(com.baidu.tieba.v.root_main_view_cover);
            this.bwM = (TbImageView) this.bwK.findViewById(com.baidu.tieba.v.icon_1);
            this.bwN = (TbImageView) this.bwK.findViewById(com.baidu.tieba.v.icon_2);
            this.bwO = (TbImageView) this.bwK.findViewById(com.baidu.tieba.v.icon_3);
            this.bwP = (TbImageView) this.bwK.findViewById(com.baidu.tieba.v.icon_4);
            this.bwQ = (TbImageView) this.bwK.findViewById(com.baidu.tieba.v.icon_5);
            this.bwR = (TbImageView) this.bwK.findViewById(com.baidu.tieba.v.icon_6);
            this.bwS = (TbImageView) this.bwK.findViewById(com.baidu.tieba.v.icon_7);
            this.bwT = (TbImageView) this.bwK.findViewById(com.baidu.tieba.v.icon_8);
            this.bwU = (TbImageView) this.bwK.findViewById(com.baidu.tieba.v.icon_9);
            this.bwV = (TbImageView) this.bwK.findViewById(com.baidu.tieba.v.icon_10);
            this.mNext = (Button) this.bwK.findViewById(com.baidu.tieba.v.btn_next);
            this.bwW.put(1, this.bwM);
            this.bwW.put(2, this.bwN);
            this.bwW.put(3, this.bwO);
            this.bwW.put(4, this.bwP);
            this.bwW.put(5, this.bwQ);
            this.bwW.put(6, this.bwR);
            this.bwW.put(7, this.bwS);
            this.bwW.put(8, this.bwT);
            this.bwW.put(9, this.bwU);
            this.bwW.put(10, this.bwV);
            this.mNext.setOnClickListener(this.adP);
            this.bwM.setOnClickListener(this.adP);
            this.bwN.setOnClickListener(this.adP);
            this.bwO.setOnClickListener(this.adP);
            this.bwP.setOnClickListener(this.adP);
            this.bwQ.setOnClickListener(this.adP);
            this.bwR.setOnClickListener(this.adP);
            this.bwS.setOnClickListener(this.adP);
            this.bwT.setOnClickListener(this.adP);
            this.bwU.setOnClickListener(this.adP);
            this.bwU.setOnClickListener(this.adP);
            this.bwV.setOnClickListener(this.adP);
            return this.bwK;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.bwE.Wb();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
