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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes2.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private ViewGroup aXW;
    private View iTB;
    private NewUserGuideActivity nuP;
    private TbImageView nuW;
    private TbImageView nuX;
    private TbImageView nuY;
    private TbImageView nuZ;
    private NewUserGuideModel nuz;
    private TbImageView nva;
    private TbImageView nvb;
    private TbImageView nvc;
    private TbImageView nvd;
    private TbImageView nve;
    private TbImageView nvf;
    private Button nvg;
    private final Hashtable<Integer, TbImageView> nuV = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean nvh = false;
    private boolean nvi = true;
    private final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.nvg) {
                    if (NewUserGuideMainFragment.this.nuP.dOl()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.nuP.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.nuP.finish();
                }
            } else if (NewUserGuideMainFragment.this.nvi) {
                NewUserGuideMainFragment.this.nvi = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.nuP, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dOs() {
                        NewUserGuideMainFragment.this.iTB.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.iTB.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.nvi = true;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void dOs();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.nvh = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nuP = (NewUserGuideActivity) getBaseFragmentActivity();
        this.nuz = this.nuP.dOn();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.nuz != null && !this.nvh) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.nuP.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.nuz.dOu());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.nuV.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.aXW = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.iTB = this.aXW.findViewById(R.id.root_main_view_cover);
            this.nuW = (TbImageView) this.aXW.findViewById(R.id.icon_1);
            this.nuX = (TbImageView) this.aXW.findViewById(R.id.icon_2);
            this.nuY = (TbImageView) this.aXW.findViewById(R.id.icon_3);
            this.nuZ = (TbImageView) this.aXW.findViewById(R.id.icon_4);
            this.nva = (TbImageView) this.aXW.findViewById(R.id.icon_5);
            this.nvb = (TbImageView) this.aXW.findViewById(R.id.icon_6);
            this.nvc = (TbImageView) this.aXW.findViewById(R.id.icon_7);
            this.nvd = (TbImageView) this.aXW.findViewById(R.id.icon_8);
            this.nve = (TbImageView) this.aXW.findViewById(R.id.icon_9);
            this.nvf = (TbImageView) this.aXW.findViewById(R.id.icon_10);
            this.nvg = (Button) this.aXW.findViewById(R.id.btn_next);
            this.nuV.put(1, this.nuW);
            this.nuV.put(2, this.nuX);
            this.nuV.put(3, this.nuY);
            this.nuV.put(4, this.nuZ);
            this.nuV.put(5, this.nva);
            this.nuV.put(6, this.nvb);
            this.nuV.put(7, this.nvc);
            this.nuV.put(8, this.nvd);
            this.nuV.put(9, this.nve);
            this.nuV.put(10, this.nvf);
            this.nvg.setOnClickListener(this.onClickListener);
            this.nuW.setOnClickListener(this.onClickListener);
            this.nuX.setOnClickListener(this.onClickListener);
            this.nuY.setOnClickListener(this.onClickListener);
            this.nuZ.setOnClickListener(this.onClickListener);
            this.nva.setOnClickListener(this.onClickListener);
            this.nvb.setOnClickListener(this.onClickListener);
            this.nvc.setOnClickListener(this.onClickListener);
            this.nvd.setOnClickListener(this.onClickListener);
            this.nve.setOnClickListener(this.onClickListener);
            this.nve.setOnClickListener(this.onClickListener);
            this.nvf.setOnClickListener(this.onClickListener);
            return this.aXW;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.nuP.dOp();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
