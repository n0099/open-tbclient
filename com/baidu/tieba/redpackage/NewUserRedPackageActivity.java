package com.baidu.tieba.redpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ImageView.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes22.dex */
public class NewUserRedPackageActivity extends BaseActivity {
    private s esI;
    private ImageView fQd;
    private RoundRelativeLayout mCp;
    private ImageView mCq;
    private TextView mCr;
    private TextView mCs;
    private TextView mCt;
    private NewUserRedPackageData mCu;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.redpackage.NewUserRedPackageActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.redpackage.NewUserRedPackageActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != NewUserRedPackageActivity.this.fQd.getId()) {
                if (view.getId() == NewUserRedPackageActivity.this.mCt.getId()) {
                    TiebaStatic.log(new aq("c13684").al("obj_type", 2));
                    if (TbadkCoreApplication.isLogin()) {
                        if (NewUserRedPackageActivity.this.mCu != null) {
                            be.brr().b(NewUserRedPackageActivity.this.getPageContext(), new String[]{NewUserRedPackageActivity.this.mCu.clickUrl});
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
            TiebaStatic.log(new aq("c13684").al("obj_type", 3));
            NewUserRedPackageActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_user_red_package);
        this.mCp = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
        this.mCp.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.mCq = (ImageView) findViewById(R.id.top_pic);
        this.fQd = (ImageView) findViewById(R.id.img_close);
        this.fQd.setOnClickListener(this.mOnClickListener);
        this.mCr = (TextView) findViewById(R.id.money_count);
        this.mCs = (TextView) findViewById(R.id.money_info);
        this.mCt = (TextView) findViewById(R.id.btn_receive);
        this.mCt.setOnClickListener(this.mOnClickListener);
        setData();
        TiebaStatic.log(new aq("c13684").al("obj_type", 1));
        this.esI = new s();
    }

    private void setData() {
        if (getIntent() != null) {
            this.mCu = (NewUserRedPackageData) getIntent().getSerializableExtra("key_data");
            if (this.mCu != null) {
                a aVar = (a) c.mS().loadResourceFromMemery(this.mCu.topPicUrl, 10, new Object[0]);
                if (aVar != null) {
                    this.mCq.setImageBitmap(aVar.getRawBitmap());
                }
                this.mCr.setText(String.format(getString(R.string.new_user_red_package_money_count), this.mCu.money));
                this.mCs.setText(getString(R.string.new_user_red_package_money_info));
                this.mCt.setText(getString(R.string.new_user_red_package_receive));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mCp, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mCr, R.color.cp_cont_b);
        ap.setViewTextColor(this.mCs, R.color.cp_cont_b);
        ap.setViewTextColor(this.mCt, R.color.cp_link_tip_a);
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
        if (i == 25046 && this.mCu != null) {
            this.esI.bhf();
            be.brr().b(getPageContext(), new String[]{this.mCu.clickUrl});
            finish();
        }
    }
}
