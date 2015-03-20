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
    private com.baidu.tbadk.coreExtra.share.d aQg;
    GameInfoData aQi = com.baidu.tbadk.game.b.zh().getGameInfoData();
    private int byn;
    private int byo;
    private static String REQUEST_CODE = "tb_request_code";
    private static String KEY_FROME_WHERE = "key_from_where";
    private static int byp = 23003;
    private static int byq = 2;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        setContentView(w.lightapp_game_share);
        if (bundle != null) {
            this.byn = bundle.getInt(REQUEST_CODE, 0);
            this.byo = bundle.getInt(KEY_FROME_WHERE, 0);
        } else if (getIntent() != null) {
            this.byn = getIntent().getIntExtra(REQUEST_CODE, 0);
            this.byo = getIntent().getIntExtra(KEY_FROME_WHERE, 0);
        } else {
            finish();
        }
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(getResources().getDrawable(u.bg_gift_shade));
        }
        if (this.byn == byp && this.byo == byq) {
            showShareDialog();
        }
    }

    public void showShareDialog() {
        ShareFromGameCenterMsgData zj = com.baidu.tbadk.game.b.zh().zj();
        com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
        fVar.title = zj.getTitle();
        fVar.content = zj.getContent();
        fVar.adm = zj.getShareUrl();
        if (StringUtils.isNull(zj.getImageUrl())) {
            fVar.adn = null;
        } else {
            fVar.adn = Uri.parse(zj.getImageUrl());
        }
        this.aQg = new com.baidu.tbadk.coreExtra.share.d(getPageContext().getPageActivity());
        this.aQg.a(fVar, true);
        this.aQg.setIsCopyLink(false);
        TextView u = this.aQg.u(y.share_tieba_qunzu, u.icon_unite_share_qunzu);
        this.aQg.a(u);
        u.setOnClickListener(new c(this));
        TextView u2 = this.aQg.u(y.forum_friend, u.icon_unite_share_baf);
        this.aQg.a(u2);
        u2.setOnClickListener(new d(this));
        this.aQg.d(new e(this));
        this.aQg.show();
        this.aQg.setOnDismissListener(new f(this));
    }
}
