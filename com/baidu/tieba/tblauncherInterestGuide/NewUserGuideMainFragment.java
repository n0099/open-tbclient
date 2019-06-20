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
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes4.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View feI;
    private NewUserGuideModel jfF;
    private NewUserGuideActivity jfZ;
    private TbImageView jgg;
    private TbImageView jgh;
    private TbImageView jgi;
    private TbImageView jgj;
    private TbImageView jgk;
    private TbImageView jgl;
    private TbImageView jgm;
    private TbImageView jgn;
    private TbImageView jgo;
    private TbImageView jgp;
    private Button jgq;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> jgf = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean jgr = false;
    private boolean jgs = true;
    private final View.OnClickListener ckI = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.jgq) {
                    if (NewUserGuideMainFragment.this.jfZ.cpa()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.jfZ.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.jfZ.finish();
                }
            } else if (NewUserGuideMainFragment.this.jgs) {
                NewUserGuideMainFragment.this.jgs = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.jfZ, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cpi() {
                        NewUserGuideMainFragment.this.feI.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.feI.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.jgs = true;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void cpi();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.jgr = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jfZ = (NewUserGuideActivity) getBaseFragmentActivity();
        this.jfF = this.jfZ.cpc();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.jfF != null && !this.jgr) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.jfZ.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.jfF.cpk());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.jgf.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.feI = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.jgg = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.jgh = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.jgi = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.jgj = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.jgk = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.jgl = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.jgm = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.jgn = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.jgo = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.jgp = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.jgq = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.jgf.put(1, this.jgg);
            this.jgf.put(2, this.jgh);
            this.jgf.put(3, this.jgi);
            this.jgf.put(4, this.jgj);
            this.jgf.put(5, this.jgk);
            this.jgf.put(6, this.jgl);
            this.jgf.put(7, this.jgm);
            this.jgf.put(8, this.jgn);
            this.jgf.put(9, this.jgo);
            this.jgf.put(10, this.jgp);
            this.jgq.setOnClickListener(this.ckI);
            this.jgg.setOnClickListener(this.ckI);
            this.jgh.setOnClickListener(this.ckI);
            this.jgi.setOnClickListener(this.ckI);
            this.jgj.setOnClickListener(this.ckI);
            this.jgk.setOnClickListener(this.ckI);
            this.jgl.setOnClickListener(this.ckI);
            this.jgm.setOnClickListener(this.ckI);
            this.jgn.setOnClickListener(this.ckI);
            this.jgo.setOnClickListener(this.ckI);
            this.jgo.setOnClickListener(this.ckI);
            this.jgp.setOnClickListener(this.ckI);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.jfZ.cpe();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
