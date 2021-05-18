package com.baidu.tieba.redpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import d.a.c.e.l.d;
import d.a.c.e.p.l;
import d.a.j0.a.t;
/* loaded from: classes5.dex */
public class NewUserRedPackageActivity extends BaseActivity {
    public ImageView mBgImage;
    public ImageView mCloseBtnImage;
    public NewUserRedPackageData mData;
    public t mGetMoneyModel;
    public View.OnClickListener mOnClickListener = new a();
    public RoundRelativeLayout mRoundCornerLayout;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != NewUserRedPackageActivity.this.mCloseBtnImage.getId()) {
                if (view.getId() == NewUserRedPackageActivity.this.mBgImage.getId()) {
                    TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 2));
                    if (TbadkCoreApplication.isLogin()) {
                        if (NewUserRedPackageActivity.this.mData != null) {
                            UrlManager.getInstance().dealOneLink(NewUserRedPackageActivity.this.getPageContext(), new String[]{NewUserRedPackageActivity.this.mData.clickUrl});
                            NewUserRedPackageActivity.this.finish();
                            return;
                        }
                        return;
                    }
                    NewUserRedPackageActivity.this.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(NewUserRedPackageActivity.this.getActivity(), true, 25046)));
                    return;
                }
                return;
            }
            TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 3));
            NewUserRedPackageActivity.this.finish();
        }
    }

    private void setData() {
        d.a.c.j.d.a aVar;
        if (getIntent() == null) {
            return;
        }
        NewUserRedPackageData newUserRedPackageData = (NewUserRedPackageData) getIntent().getSerializableExtra("key_data");
        this.mData = newUserRedPackageData;
        if (newUserRedPackageData == null || (aVar = (d.a.c.j.d.a) d.h().n(this.mData.topPicUrl, 10, new Object[0])) == null) {
            return;
        }
        this.mBgImage.setImageBitmap(aVar.p());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 25046 || this.mData == null) {
            return;
        }
        this.mGetMoneyModel.a();
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{this.mData.clickUrl});
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setBackgroundColor(this.mRoundCornerLayout, R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_user_red_package);
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
        this.mRoundCornerLayout = roundRelativeLayout;
        roundRelativeLayout.setAllCornerRound(l.g(this, R.dimen.tbds31));
        this.mBgImage = (ImageView) findViewById(R.id.img_bg);
        this.mCloseBtnImage = (ImageView) findViewById(R.id.img_btn_close);
        this.mBgImage.setOnClickListener(this.mOnClickListener);
        this.mCloseBtnImage.setOnClickListener(this.mOnClickListener);
        setData();
        TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 1));
        this.mGetMoneyModel = new t();
    }
}
