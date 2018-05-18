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
public class NewUserGuideMainFragment extends BaseFragment {
    private View cSz;
    private NewUserGuideModel gCK;
    private NewUserGuideActivity gDf;
    private TbImageView gDm;
    private TbImageView gDn;
    private TbImageView gDo;
    private TbImageView gDp;
    private TbImageView gDq;
    private TbImageView gDr;
    private TbImageView gDs;
    private TbImageView gDt;
    private TbImageView gDu;
    private TbImageView gDv;
    private Button gDw;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> gDl = new Hashtable<>();
    private boolean gCM = false;
    private boolean gDx = false;
    private boolean gDy = true;
    private final View.OnClickListener axH = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getTag() == null || !(view2.getTag() instanceof InterestFrsData.Tag)) {
                if (view2 == NewUserGuideMainFragment.this.gDw) {
                    if (NewUserGuideMainFragment.this.gDf.bud()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.gDf.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.gCM)));
                    NewUserGuideMainFragment.this.gDf.finish();
                }
            } else if (NewUserGuideMainFragment.this.gDy) {
                NewUserGuideMainFragment.this.gDy = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.gDf, (InterestFrsData.Tag) view2.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bul() {
                        NewUserGuideMainFragment.this.cSz.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.cSz.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.gDy = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bul();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.gDx = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gDf = (NewUserGuideActivity) getBaseFragmentActivity();
        this.gCK = this.gDf.buf();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.gCK != null && !this.gDx) {
            if (bundle != null) {
                this.gCM = bundle.getBoolean("is_new_user");
            } else {
                this.gCM = this.gDf.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.gCK.bun());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.gDl.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(d.i.guide_main, (ViewGroup) null);
            this.cSz = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.gDm = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.gDn = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.gDo = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.gDp = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.gDq = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.gDr = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.gDs = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.gDt = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.gDu = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.gDv = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.gDw = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.gDl.put(1, this.gDm);
            this.gDl.put(2, this.gDn);
            this.gDl.put(3, this.gDo);
            this.gDl.put(4, this.gDp);
            this.gDl.put(5, this.gDq);
            this.gDl.put(6, this.gDr);
            this.gDl.put(7, this.gDs);
            this.gDl.put(8, this.gDt);
            this.gDl.put(9, this.gDu);
            this.gDl.put(10, this.gDv);
            this.gDw.setOnClickListener(this.axH);
            this.gDm.setOnClickListener(this.axH);
            this.gDn.setOnClickListener(this.axH);
            this.gDo.setOnClickListener(this.axH);
            this.gDp.setOnClickListener(this.axH);
            this.gDq.setOnClickListener(this.axH);
            this.gDr.setOnClickListener(this.axH);
            this.gDs.setOnClickListener(this.axH);
            this.gDt.setOnClickListener(this.axH);
            this.gDu.setOnClickListener(this.axH);
            this.gDu.setOnClickListener(this.axH);
            this.gDv.setOnClickListener(this.axH);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.gDf.buh();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
