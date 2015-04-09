package com.baidu.tieba.light.share;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class LightappGameShare extends BaseActivity<LightappGameShare> {
    private com.baidu.tbadk.coreExtra.share.d aQx;
    GameInfoData aQz = com.baidu.tbadk.game.b.zn().getGameInfoData();
    private int byD;
    private int byE;
    private static String REQUEST_CODE = "tb_request_code";
    private static String KEY_FROME_WHERE = "key_from_where";
    private static int byF = 23003;
    private static int byG = 2;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        setContentView(w.lightapp_game_share);
        if (bundle != null) {
            this.byD = bundle.getInt(REQUEST_CODE, 0);
            this.byE = bundle.getInt(KEY_FROME_WHERE, 0);
        } else if (getIntent() != null) {
            this.byD = getIntent().getIntExtra(REQUEST_CODE, 0);
            this.byE = getIntent().getIntExtra(KEY_FROME_WHERE, 0);
        } else {
            finish();
        }
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(getResources().getDrawable(u.bg_gift_shade));
        }
        if (this.byD == byF && this.byE == byG) {
            showShareDialog();
        }
    }

    public void showShareDialog() {
        ShareFromGameCenterMsgData zp = com.baidu.tbadk.game.b.zn().zp();
        com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
        fVar.title = zp.getTitle();
        fVar.content = zp.getContent();
        fVar.adu = zp.getShareUrl();
        if (StringUtils.isNull(zp.getImageUrl())) {
            fVar.adv = null;
        } else {
            fVar.adv = Uri.parse(zp.getImageUrl());
        }
        this.aQx = new com.baidu.tbadk.coreExtra.share.d(getPageContext().getPageActivity());
        this.aQx.a(fVar, true);
        this.aQx.setIsCopyLink(false);
        TextView u = this.aQx.u(y.share_tieba_qunzu, u.icon_unite_share_qunzu);
        this.aQx.a(u);
        u.setOnClickListener(new c(this));
        TextView u2 = this.aQx.u(y.forum_friend, u.icon_unite_share_baf);
        this.aQx.a(u2);
        u2.setOnClickListener(new d(this));
        this.aQx.d(new e(this));
        this.aQx.show();
        this.aQx.setOnDismissListener(new f(this));
    }
}
