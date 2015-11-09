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
    private com.baidu.tieba.launcherGuide.a.a bRJ;
    private TbImageView bSA;
    private NewUserGuideActivity bSj;
    private ViewGroup bSp;
    private View bSq;
    private TbImageView bSr;
    private TbImageView bSs;
    private TbImageView bSt;
    private TbImageView bSu;
    private TbImageView bSv;
    private TbImageView bSw;
    private TbImageView bSx;
    private TbImageView bSy;
    private TbImageView bSz;
    private Button mNext;
    private final Hashtable<Integer, TbImageView> bSB = new Hashtable<>();
    private boolean bRL = false;
    private boolean bSC = false;
    private boolean bSD = true;
    private final View.OnClickListener ajG = new l(this);

    /* loaded from: classes.dex */
    public interface a {
        void aaV();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.bSC = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bSj = (NewUserGuideActivity) getBaseFragmentActivity();
        this.bRJ = this.bSj.aaP();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.bRJ != null && !this.bSC) {
            if (bundle != null) {
                this.bRL = bundle.getBoolean("is_new_user");
            } else {
                this.bRL = this.bSj.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.bRJ.aaX());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.bSB.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.d(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.bSp = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(i.g.guide_main, (ViewGroup) null);
            this.bSq = this.bSp.findViewById(i.f.root_main_view_cover);
            this.bSr = (TbImageView) this.bSp.findViewById(i.f.icon_1);
            this.bSs = (TbImageView) this.bSp.findViewById(i.f.icon_2);
            this.bSt = (TbImageView) this.bSp.findViewById(i.f.icon_3);
            this.bSu = (TbImageView) this.bSp.findViewById(i.f.icon_4);
            this.bSv = (TbImageView) this.bSp.findViewById(i.f.icon_5);
            this.bSw = (TbImageView) this.bSp.findViewById(i.f.icon_6);
            this.bSx = (TbImageView) this.bSp.findViewById(i.f.icon_7);
            this.bSy = (TbImageView) this.bSp.findViewById(i.f.icon_8);
            this.bSz = (TbImageView) this.bSp.findViewById(i.f.icon_9);
            this.bSA = (TbImageView) this.bSp.findViewById(i.f.icon_10);
            this.mNext = (Button) this.bSp.findViewById(i.f.btn_next);
            this.bSB.put(1, this.bSr);
            this.bSB.put(2, this.bSs);
            this.bSB.put(3, this.bSt);
            this.bSB.put(4, this.bSu);
            this.bSB.put(5, this.bSv);
            this.bSB.put(6, this.bSw);
            this.bSB.put(7, this.bSx);
            this.bSB.put(8, this.bSy);
            this.bSB.put(9, this.bSz);
            this.bSB.put(10, this.bSA);
            this.mNext.setOnClickListener(this.ajG);
            this.bSr.setOnClickListener(this.ajG);
            this.bSs.setOnClickListener(this.ajG);
            this.bSt.setOnClickListener(this.ajG);
            this.bSu.setOnClickListener(this.ajG);
            this.bSv.setOnClickListener(this.ajG);
            this.bSw.setOnClickListener(this.ajG);
            this.bSx.setOnClickListener(this.ajG);
            this.bSy.setOnClickListener(this.ajG);
            this.bSz.setOnClickListener(this.ajG);
            this.bSz.setOnClickListener(this.ajG);
            this.bSA.setOnClickListener(this.ajG);
            return this.bSp;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.bSj.aaR();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
