package com.baidu.tieba.redpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes9.dex */
public class NewUserRedPackageActivity extends BaseActivity {
    private ImageView eKY;
    private RoundRelativeLayout kRq;
    private ImageView kRr;
    private TextView kRs;
    private TextView kRt;
    private TextView kRu;
    private NewUserRedPackageData kRv;
    private a kRw;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.redpackage.NewUserRedPackageActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.redpackage.NewUserRedPackageActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != NewUserRedPackageActivity.this.eKY.getId()) {
                if (view.getId() == NewUserRedPackageActivity.this.kRu.getId()) {
                    TiebaStatic.log(new an("c13684").ag("obj_type", 2));
                    if (TbadkCoreApplication.isLogin()) {
                        if (NewUserRedPackageActivity.this.kRv != null) {
                            ba.aUZ().b(NewUserRedPackageActivity.this.getPageContext(), new String[]{NewUserRedPackageActivity.this.kRv.clickUrl});
                            NewUserRedPackageActivity.this.finish();
                            return;
                        }
                        return;
                    }
                    NewUserRedPackageActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewUserRedPackageActivity.this.getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
                    return;
                }
                return;
            }
            TiebaStatic.log(new an("c13684").ag("obj_type", 3));
            NewUserRedPackageActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_user_red_package);
        this.kRq = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
        this.kRq.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.kRr = (ImageView) findViewById(R.id.top_pic);
        this.eKY = (ImageView) findViewById(R.id.img_close);
        this.eKY.setOnClickListener(this.mOnClickListener);
        this.kRs = (TextView) findViewById(R.id.money_count);
        this.kRt = (TextView) findViewById(R.id.money_info);
        this.kRu = (TextView) findViewById(R.id.btn_receive);
        this.kRu.setOnClickListener(this.mOnClickListener);
        setData();
        TiebaStatic.log(new an("c13684").ag("obj_type", 1));
        this.kRw = new a(getPageContext());
    }

    private void setData() {
        if (getIntent() != null) {
            this.kRv = (NewUserRedPackageData) getIntent().getSerializableExtra(NewUserRedPackageActivityConfig.KEY_DATA);
            if (this.kRv != null) {
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.kX().loadResourceFromMemery(this.kRv.topPicUrl, 10, new Object[0]);
                if (aVar != null) {
                    this.kRr.setImageBitmap(aVar.getRawBitmap());
                }
                this.kRs.setText(String.format(getString(R.string.new_user_red_package_money_count), this.kRv.money));
                this.kRt.setText(getString(R.string.new_user_red_package_money_info));
                this.kRu.setText(getString(R.string.new_user_red_package_receive));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.kRq, R.color.cp_bg_line_d);
        am.setViewTextColor(this.kRs, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kRt, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.kRu, (int) R.color.cp_link_tip_a);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25046 && this.kRv != null) {
            this.kRw.cVG();
            ba.aUZ().b(getPageContext(), new String[]{this.kRv.clickUrl});
            finish();
        }
    }
}
