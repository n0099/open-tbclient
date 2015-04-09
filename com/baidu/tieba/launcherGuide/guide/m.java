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
    private NewUserGuideActivity bwU;
    private com.baidu.tieba.launcherGuide.a.a bww;
    private ViewGroup bxa;
    private View bxb;
    private TbImageView bxc;
    private TbImageView bxd;
    private TbImageView bxe;
    private TbImageView bxf;
    private TbImageView bxg;
    private TbImageView bxh;
    private TbImageView bxi;
    private TbImageView bxj;
    private TbImageView bxk;
    private TbImageView bxl;
    private Button mNext;
    private final Hashtable<Integer, TbImageView> bxm = new Hashtable<>();
    private boolean bwy = false;
    private boolean bxn = false;
    private boolean bxo = true;
    private final View.OnClickListener adX = new n(this);

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.bxn = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bwU = (NewUserGuideActivity) getBaseFragmentActivity();
        this.bww = this.bwU.Wm();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.bww != null && !this.bxn) {
            if (bundle != null) {
                this.bwy = bundle.getBoolean("is_new_user");
            } else {
                this.bwy = this.bwU.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.bww.Wu());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.bxm.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.c(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.bxa = (ViewGroup) com.baidu.adp.lib.g.b.hH().inflate(layoutInflater.getContext(), com.baidu.tieba.w.guide_main, null);
            this.bxb = this.bxa.findViewById(com.baidu.tieba.v.root_main_view_cover);
            this.bxc = (TbImageView) this.bxa.findViewById(com.baidu.tieba.v.icon_1);
            this.bxd = (TbImageView) this.bxa.findViewById(com.baidu.tieba.v.icon_2);
            this.bxe = (TbImageView) this.bxa.findViewById(com.baidu.tieba.v.icon_3);
            this.bxf = (TbImageView) this.bxa.findViewById(com.baidu.tieba.v.icon_4);
            this.bxg = (TbImageView) this.bxa.findViewById(com.baidu.tieba.v.icon_5);
            this.bxh = (TbImageView) this.bxa.findViewById(com.baidu.tieba.v.icon_6);
            this.bxi = (TbImageView) this.bxa.findViewById(com.baidu.tieba.v.icon_7);
            this.bxj = (TbImageView) this.bxa.findViewById(com.baidu.tieba.v.icon_8);
            this.bxk = (TbImageView) this.bxa.findViewById(com.baidu.tieba.v.icon_9);
            this.bxl = (TbImageView) this.bxa.findViewById(com.baidu.tieba.v.icon_10);
            this.mNext = (Button) this.bxa.findViewById(com.baidu.tieba.v.btn_next);
            this.bxm.put(1, this.bxc);
            this.bxm.put(2, this.bxd);
            this.bxm.put(3, this.bxe);
            this.bxm.put(4, this.bxf);
            this.bxm.put(5, this.bxg);
            this.bxm.put(6, this.bxh);
            this.bxm.put(7, this.bxi);
            this.bxm.put(8, this.bxj);
            this.bxm.put(9, this.bxk);
            this.bxm.put(10, this.bxl);
            this.mNext.setOnClickListener(this.adX);
            this.bxc.setOnClickListener(this.adX);
            this.bxd.setOnClickListener(this.adX);
            this.bxe.setOnClickListener(this.adX);
            this.bxf.setOnClickListener(this.adX);
            this.bxg.setOnClickListener(this.adX);
            this.bxh.setOnClickListener(this.adX);
            this.bxi.setOnClickListener(this.adX);
            this.bxj.setOnClickListener(this.adX);
            this.bxk.setOnClickListener(this.adX);
            this.bxk.setOnClickListener(this.adX);
            this.bxl.setOnClickListener(this.adX);
            return this.bxa;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.bwU.Wo();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
