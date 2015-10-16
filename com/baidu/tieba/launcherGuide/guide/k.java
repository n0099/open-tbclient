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
    private NewUserGuideActivity bRO;
    private ViewGroup bRU;
    private View bRV;
    private TbImageView bRW;
    private TbImageView bRX;
    private TbImageView bRY;
    private TbImageView bRZ;
    private com.baidu.tieba.launcherGuide.a.a bRo;
    private TbImageView bSa;
    private TbImageView bSb;
    private TbImageView bSc;
    private TbImageView bSd;
    private TbImageView bSe;
    private TbImageView bSf;
    private Button mNext;
    private final Hashtable<Integer, TbImageView> bSg = new Hashtable<>();
    private boolean bRq = false;
    private boolean bSh = false;
    private boolean bSi = true;
    private final View.OnClickListener ajB = new l(this);

    /* loaded from: classes.dex */
    public interface a {
        void aaE();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.bSh = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bRO = (NewUserGuideActivity) getBaseFragmentActivity();
        this.bRo = this.bRO.aay();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.bRo != null && !this.bSh) {
            if (bundle != null) {
                this.bRq = bundle.getBoolean("is_new_user");
            } else {
                this.bRq = this.bRO.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.bRo.aaG());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.bSg.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.d(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.bRU = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(i.g.guide_main, (ViewGroup) null);
            this.bRV = this.bRU.findViewById(i.f.root_main_view_cover);
            this.bRW = (TbImageView) this.bRU.findViewById(i.f.icon_1);
            this.bRX = (TbImageView) this.bRU.findViewById(i.f.icon_2);
            this.bRY = (TbImageView) this.bRU.findViewById(i.f.icon_3);
            this.bRZ = (TbImageView) this.bRU.findViewById(i.f.icon_4);
            this.bSa = (TbImageView) this.bRU.findViewById(i.f.icon_5);
            this.bSb = (TbImageView) this.bRU.findViewById(i.f.icon_6);
            this.bSc = (TbImageView) this.bRU.findViewById(i.f.icon_7);
            this.bSd = (TbImageView) this.bRU.findViewById(i.f.icon_8);
            this.bSe = (TbImageView) this.bRU.findViewById(i.f.icon_9);
            this.bSf = (TbImageView) this.bRU.findViewById(i.f.icon_10);
            this.mNext = (Button) this.bRU.findViewById(i.f.btn_next);
            this.bSg.put(1, this.bRW);
            this.bSg.put(2, this.bRX);
            this.bSg.put(3, this.bRY);
            this.bSg.put(4, this.bRZ);
            this.bSg.put(5, this.bSa);
            this.bSg.put(6, this.bSb);
            this.bSg.put(7, this.bSc);
            this.bSg.put(8, this.bSd);
            this.bSg.put(9, this.bSe);
            this.bSg.put(10, this.bSf);
            this.mNext.setOnClickListener(this.ajB);
            this.bRW.setOnClickListener(this.ajB);
            this.bRX.setOnClickListener(this.ajB);
            this.bRY.setOnClickListener(this.ajB);
            this.bRZ.setOnClickListener(this.ajB);
            this.bSa.setOnClickListener(this.ajB);
            this.bSb.setOnClickListener(this.ajB);
            this.bSc.setOnClickListener(this.ajB);
            this.bSd.setOnClickListener(this.ajB);
            this.bSe.setOnClickListener(this.ajB);
            this.bSe.setOnClickListener(this.ajB);
            this.bSf.setOnClickListener(this.ajB);
            return this.bRU;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.bRO.aaA();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
