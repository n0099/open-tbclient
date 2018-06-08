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
    private View dbG;
    private NewUserGuideActivity gOH;
    private TbImageView gOO;
    private TbImageView gOP;
    private TbImageView gOQ;
    private TbImageView gOR;
    private TbImageView gOS;
    private TbImageView gOT;
    private TbImageView gOU;
    private TbImageView gOV;
    private TbImageView gOW;
    private TbImageView gOX;
    private Button gOY;
    private NewUserGuideModel gOm;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> gON = new Hashtable<>();
    private boolean gOo = false;
    private boolean gOZ = false;
    private boolean gPa = true;
    private final View.OnClickListener aGc = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.gOY) {
                    if (NewUserGuideMainFragment.this.gOH.bzg()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.gOH.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.gOo)));
                    NewUserGuideMainFragment.this.gOH.finish();
                }
            } else if (NewUserGuideMainFragment.this.gPa) {
                NewUserGuideMainFragment.this.gPa = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.gOH, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bzo() {
                        NewUserGuideMainFragment.this.dbG.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.dbG.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.gPa = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bzo();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.gOZ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gOH = (NewUserGuideActivity) getBaseFragmentActivity();
        this.gOm = this.gOH.bzi();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.gOm != null && !this.gOZ) {
            if (bundle != null) {
                this.gOo = bundle.getBoolean("is_new_user");
            } else {
                this.gOo = this.gOH.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.gOm.bzq());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.gON.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.dbG = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.gOO = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.gOP = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.gOQ = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.gOR = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.gOS = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.gOT = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.gOU = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.gOV = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.gOW = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.gOX = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.gOY = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.gON.put(1, this.gOO);
            this.gON.put(2, this.gOP);
            this.gON.put(3, this.gOQ);
            this.gON.put(4, this.gOR);
            this.gON.put(5, this.gOS);
            this.gON.put(6, this.gOT);
            this.gON.put(7, this.gOU);
            this.gON.put(8, this.gOV);
            this.gON.put(9, this.gOW);
            this.gON.put(10, this.gOX);
            this.gOY.setOnClickListener(this.aGc);
            this.gOO.setOnClickListener(this.aGc);
            this.gOP.setOnClickListener(this.aGc);
            this.gOQ.setOnClickListener(this.aGc);
            this.gOR.setOnClickListener(this.aGc);
            this.gOS.setOnClickListener(this.aGc);
            this.gOT.setOnClickListener(this.aGc);
            this.gOU.setOnClickListener(this.aGc);
            this.gOV.setOnClickListener(this.aGc);
            this.gOW.setOnClickListener(this.aGc);
            this.gOW.setOnClickListener(this.aGc);
            this.gOX.setOnClickListener(this.aGc);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.gOH.bzk();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
