package com.baidu.tieba.light.share;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class LightappGameShare extends BaseActivity<LightappGameShare> {
    private com.baidu.tbadk.coreExtra.share.d aIX;
    GameInfoData aIZ = com.baidu.tbadk.game.b.vv().getGameInfoData();
    private int bqJ;
    private int bqK;
    private static String REQUEST_CODE = "tb_request_code";
    private static String KEY_FROME_WHERE = "key_from_where";
    private static int bqL = 23003;
    private static int bqM = 2;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.lightapp_game_share);
        if (bundle != null) {
            this.bqJ = bundle.getInt(REQUEST_CODE, 0);
            this.bqK = bundle.getInt(KEY_FROME_WHERE, 0);
        } else if (getIntent() != null) {
            this.bqJ = getIntent().getIntExtra(REQUEST_CODE, 0);
            this.bqK = getIntent().getIntExtra(KEY_FROME_WHERE, 0);
        } else {
            finish();
        }
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(getResources().getDrawable(v.bg_gift_shade));
        }
        if (this.bqJ == bqL && this.bqK == bqM) {
            showShareDialog();
        }
    }

    public void showShareDialog() {
        ShareFromGameCenterMsgData vx = com.baidu.tbadk.game.b.vv().vx();
        com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
        fVar.title = vx.getTitle();
        fVar.content = vx.getContent();
        fVar.SJ = vx.getShareUrl();
        if (StringUtils.isNull(vx.getImageUrl())) {
            fVar.SL = null;
        } else {
            fVar.SL = Uri.parse(vx.getImageUrl());
        }
        this.aIX = new com.baidu.tbadk.coreExtra.share.d(getPageContext().getPageActivity());
        this.aIX.a(fVar, true);
        this.aIX.aw(false);
        TextView w = this.aIX.w(z.share_tieba_qunzu, v.icon_unite_share_qunzu);
        this.aIX.a(w);
        w.setOnClickListener(new c(this));
        TextView w2 = this.aIX.w(z.forum_friend, v.icon_unite_share_baf);
        this.aIX.a(w2);
        w2.setOnClickListener(new d(this));
        this.aIX.b(new e(this));
        this.aIX.show();
        this.aIX.setOnDismissListener(new f(this));
    }
}
