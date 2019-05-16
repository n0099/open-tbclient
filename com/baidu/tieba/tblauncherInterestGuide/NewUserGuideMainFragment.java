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
    private View feH;
    private NewUserGuideActivity jfU;
    private NewUserGuideModel jfz;
    private TbImageView jgb;
    private TbImageView jgc;
    private TbImageView jgd;
    private TbImageView jge;
    private TbImageView jgf;
    private TbImageView jgg;
    private TbImageView jgh;
    private TbImageView jgi;
    private TbImageView jgj;
    private TbImageView jgk;
    private Button jgl;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> jga = new Hashtable<>();
    private boolean jfB = false;
    private boolean jgm = false;
    private boolean jgn = true;
    private final View.OnClickListener ckH = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.jgl) {
                    if (NewUserGuideMainFragment.this.jfU.coX()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.jfU.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.jfB)));
                    NewUserGuideMainFragment.this.jfU.finish();
                }
            } else if (NewUserGuideMainFragment.this.jgn) {
                NewUserGuideMainFragment.this.jgn = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.jfU, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cpf() {
                        NewUserGuideMainFragment.this.feH.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.feH.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.jgn = true;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void cpf();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.jgm = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jfU = (NewUserGuideActivity) getBaseFragmentActivity();
        this.jfz = this.jfU.coZ();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.jfz != null && !this.jgm) {
            if (bundle != null) {
                this.jfB = bundle.getBoolean("is_new_user");
            } else {
                this.jfB = this.jfU.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.jfz.cph());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.jga.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.feH = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.jgb = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.jgc = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.jgd = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.jge = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.jgf = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.jgg = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.jgh = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.jgi = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.jgj = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.jgk = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.jgl = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.jga.put(1, this.jgb);
            this.jga.put(2, this.jgc);
            this.jga.put(3, this.jgd);
            this.jga.put(4, this.jge);
            this.jga.put(5, this.jgf);
            this.jga.put(6, this.jgg);
            this.jga.put(7, this.jgh);
            this.jga.put(8, this.jgi);
            this.jga.put(9, this.jgj);
            this.jga.put(10, this.jgk);
            this.jgl.setOnClickListener(this.ckH);
            this.jgb.setOnClickListener(this.ckH);
            this.jgc.setOnClickListener(this.ckH);
            this.jgd.setOnClickListener(this.ckH);
            this.jge.setOnClickListener(this.ckH);
            this.jgf.setOnClickListener(this.ckH);
            this.jgg.setOnClickListener(this.ckH);
            this.jgh.setOnClickListener(this.ckH);
            this.jgi.setOnClickListener(this.ckH);
            this.jgj.setOnClickListener(this.ckH);
            this.jgj.setOnClickListener(this.ckH);
            this.jgk.setOnClickListener(this.ckH);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.jfU.cpb();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
