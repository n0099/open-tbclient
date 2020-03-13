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
/* loaded from: classes9.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View ghK;
    private NewUserGuideActivity knR;
    private TbImageView knY;
    private TbImageView knZ;
    private NewUserGuideModel knz;
    private TbImageView koa;
    private TbImageView kob;
    private TbImageView koc;
    private TbImageView kod;
    private TbImageView koe;
    private TbImageView kof;
    private TbImageView kog;
    private TbImageView koh;
    private Button koi;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> knX = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean koj = false;
    private boolean kok = true;
    private final View.OnClickListener drw = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.koi) {
                    if (NewUserGuideMainFragment.this.knR.cNr()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.knR.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.knR.finish();
                }
            } else if (NewUserGuideMainFragment.this.kok) {
                NewUserGuideMainFragment.this.kok = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.knR, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cNy() {
                        NewUserGuideMainFragment.this.ghK.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.ghK.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.kok = true;
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void cNy();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.koj = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.knR = (NewUserGuideActivity) getBaseFragmentActivity();
        this.knz = this.knR.cNt();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.knz != null && !this.koj) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.knR.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.knz.cNA());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.knX.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.ghK = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.knY = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.knZ = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.koa = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.kob = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.koc = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.kod = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.koe = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.kof = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.kog = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.koh = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.koi = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.knX.put(1, this.knY);
            this.knX.put(2, this.knZ);
            this.knX.put(3, this.koa);
            this.knX.put(4, this.kob);
            this.knX.put(5, this.koc);
            this.knX.put(6, this.kod);
            this.knX.put(7, this.koe);
            this.knX.put(8, this.kof);
            this.knX.put(9, this.kog);
            this.knX.put(10, this.koh);
            this.koi.setOnClickListener(this.drw);
            this.knY.setOnClickListener(this.drw);
            this.knZ.setOnClickListener(this.drw);
            this.koa.setOnClickListener(this.drw);
            this.kob.setOnClickListener(this.drw);
            this.koc.setOnClickListener(this.drw);
            this.kod.setOnClickListener(this.drw);
            this.koe.setOnClickListener(this.drw);
            this.kof.setOnClickListener(this.drw);
            this.kog.setOnClickListener(this.drw);
            this.kog.setOnClickListener(this.drw);
            this.koh.setOnClickListener(this.drw);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.knR.cNv();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
