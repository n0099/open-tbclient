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
    private NewUserGuideModel jfB;
    private NewUserGuideActivity jfV;
    private TbImageView jgc;
    private TbImageView jgd;
    private TbImageView jge;
    private TbImageView jgf;
    private TbImageView jgg;
    private TbImageView jgh;
    private TbImageView jgi;
    private TbImageView jgj;
    private TbImageView jgk;
    private TbImageView jgl;
    private Button jgm;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> jgb = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean jgn = false;
    private boolean jgo = true;
    private final View.OnClickListener ckH = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.jgm) {
                    if (NewUserGuideMainFragment.this.jfV.coZ()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.jfV.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.jfV.finish();
                }
            } else if (NewUserGuideMainFragment.this.jgo) {
                NewUserGuideMainFragment.this.jgo = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.jfV, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cph() {
                        NewUserGuideMainFragment.this.feI.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.feI.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.jgo = true;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void cph();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.jgn = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jfV = (NewUserGuideActivity) getBaseFragmentActivity();
        this.jfB = this.jfV.cpb();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.jfB != null && !this.jgn) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.jfV.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.jfB.cpj());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.jgb.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.jgc = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.jgd = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.jge = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.jgf = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.jgg = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.jgh = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.jgi = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.jgj = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.jgk = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.jgl = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.jgm = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.jgb.put(1, this.jgc);
            this.jgb.put(2, this.jgd);
            this.jgb.put(3, this.jge);
            this.jgb.put(4, this.jgf);
            this.jgb.put(5, this.jgg);
            this.jgb.put(6, this.jgh);
            this.jgb.put(7, this.jgi);
            this.jgb.put(8, this.jgj);
            this.jgb.put(9, this.jgk);
            this.jgb.put(10, this.jgl);
            this.jgm.setOnClickListener(this.ckH);
            this.jgc.setOnClickListener(this.ckH);
            this.jgd.setOnClickListener(this.ckH);
            this.jge.setOnClickListener(this.ckH);
            this.jgf.setOnClickListener(this.ckH);
            this.jgg.setOnClickListener(this.ckH);
            this.jgh.setOnClickListener(this.ckH);
            this.jgi.setOnClickListener(this.ckH);
            this.jgj.setOnClickListener(this.ckH);
            this.jgk.setOnClickListener(this.ckH);
            this.jgk.setOnClickListener(this.ckH);
            this.jgl.setOnClickListener(this.ckH);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.jfV.cpd();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
