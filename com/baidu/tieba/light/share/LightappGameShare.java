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
    private com.baidu.tbadk.coreExtra.share.d aKe;
    GameInfoData aKg = com.baidu.tbadk.game.b.vH().getGameInfoData();
    private int bsg;
    private int bsh;
    private static String REQUEST_CODE = "tb_request_code";
    private static String KEY_FROME_WHERE = "key_from_where";
    private static int bsi = 23003;
    private static int bsj = 2;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.lightapp_game_share);
        if (bundle != null) {
            this.bsg = bundle.getInt(REQUEST_CODE, 0);
            this.bsh = bundle.getInt(KEY_FROME_WHERE, 0);
        } else if (getIntent() != null) {
            this.bsg = getIntent().getIntExtra(REQUEST_CODE, 0);
            this.bsh = getIntent().getIntExtra(KEY_FROME_WHERE, 0);
        } else {
            finish();
        }
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(getResources().getDrawable(v.bg_gift_shade));
        }
        if (this.bsg == bsi && this.bsh == bsj) {
            showShareDialog();
        }
    }

    public void showShareDialog() {
        ShareFromGameCenterMsgData vJ = com.baidu.tbadk.game.b.vH().vJ();
        com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
        fVar.title = vJ.getTitle();
        fVar.content = vJ.getContent();
        fVar.Tn = vJ.getShareUrl();
        if (StringUtils.isNull(vJ.getImageUrl())) {
            fVar.To = null;
        } else {
            fVar.To = Uri.parse(vJ.getImageUrl());
        }
        this.aKe = new com.baidu.tbadk.coreExtra.share.d(getPageContext().getPageActivity());
        this.aKe.a(fVar, true);
        this.aKe.ay(false);
        TextView w = this.aKe.w(z.share_tieba_qunzu, v.icon_unite_share_qunzu);
        this.aKe.a(w);
        w.setOnClickListener(new c(this));
        TextView w2 = this.aKe.w(z.forum_friend, v.icon_unite_share_baf);
        this.aKe.a(w2);
        w2.setOnClickListener(new d(this));
        this.aKe.c(new e(this));
        this.aKe.show();
        this.aKe.setOnDismissListener(new f(this));
    }
}
