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
    private s emN;
    private ImageView fKn;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.redpackage.NewUserRedPackageActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.redpackage.NewUserRedPackageActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != NewUserRedPackageActivity.this.fKn.getId()) {
                if (view.getId() == NewUserRedPackageActivity.this.mww.getId()) {
                    TiebaStatic.log(new aq("c13684").aj("obj_type", 2));
                    if (TbadkCoreApplication.isLogin()) {
                        if (NewUserRedPackageActivity.this.mwx != null) {
                            be.boR().b(NewUserRedPackageActivity.this.getPageContext(), new String[]{NewUserRedPackageActivity.this.mwx.clickUrl});
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
            TiebaStatic.log(new aq("c13684").aj("obj_type", 3));
            NewUserRedPackageActivity.this.finish();
        }
    };
    private RoundRelativeLayout mws;
    private ImageView mwt;
    private TextView mwu;
    private TextView mwv;
    private TextView mww;
    private NewUserRedPackageData mwx;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_user_red_package);
        this.mws = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
        this.mws.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.mwt = (ImageView) findViewById(R.id.top_pic);
        this.fKn = (ImageView) findViewById(R.id.img_close);
        this.fKn.setOnClickListener(this.mOnClickListener);
        this.mwu = (TextView) findViewById(R.id.money_count);
        this.mwv = (TextView) findViewById(R.id.money_info);
        this.mww = (TextView) findViewById(R.id.btn_receive);
        this.mww.setOnClickListener(this.mOnClickListener);
        setData();
        TiebaStatic.log(new aq("c13684").aj("obj_type", 1));
        this.emN = new s();
    }

    private void setData() {
        if (getIntent() != null) {
            this.mwx = (NewUserRedPackageData) getIntent().getSerializableExtra("key_data");
            if (this.mwx != null) {
                a aVar = (a) c.mS().loadResourceFromMemery(this.mwx.topPicUrl, 10, new Object[0]);
                if (aVar != null) {
                    this.mwt.setImageBitmap(aVar.getRawBitmap());
                }
                this.mwu.setText(String.format(getString(R.string.new_user_red_package_money_count), this.mwx.money));
                this.mwv.setText(getString(R.string.new_user_red_package_money_info));
                this.mww.setText(getString(R.string.new_user_red_package_receive));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mws, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mwu, R.color.cp_cont_b);
        ap.setViewTextColor(this.mwv, R.color.cp_cont_b);
        ap.setViewTextColor(this.mww, R.color.cp_link_tip_a);
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
        if (i == 25046 && this.mwx != null) {
            this.emN.beF();
            be.boR().b(getPageContext(), new String[]{this.mwx.clickUrl});
            finish();
        }
    }
}
