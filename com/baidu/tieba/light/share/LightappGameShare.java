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
    private com.baidu.tbadk.coreExtra.share.d aKh;
    GameInfoData aKj = com.baidu.tbadk.game.b.vN().getGameInfoData();
    private int bsh;
    private int bsi;
    private static String REQUEST_CODE = "tb_request_code";
    private static String KEY_FROME_WHERE = "key_from_where";
    private static int bsj = 23003;
    private static int bsk = 2;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.lightapp_game_share);
        if (bundle != null) {
            this.bsh = bundle.getInt(REQUEST_CODE, 0);
            this.bsi = bundle.getInt(KEY_FROME_WHERE, 0);
        } else if (getIntent() != null) {
            this.bsh = getIntent().getIntExtra(REQUEST_CODE, 0);
            this.bsi = getIntent().getIntExtra(KEY_FROME_WHERE, 0);
        } else {
            finish();
        }
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(getResources().getDrawable(v.bg_gift_shade));
        }
        if (this.bsh == bsj && this.bsi == bsk) {
            showShareDialog();
        }
    }

    public void showShareDialog() {
        ShareFromGameCenterMsgData vP = com.baidu.tbadk.game.b.vN().vP();
        com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
        fVar.title = vP.getTitle();
        fVar.content = vP.getContent();
        fVar.Tq = vP.getShareUrl();
        if (StringUtils.isNull(vP.getImageUrl())) {
            fVar.Tr = null;
        } else {
            fVar.Tr = Uri.parse(vP.getImageUrl());
        }
        this.aKh = new com.baidu.tbadk.coreExtra.share.d(getPageContext().getPageActivity());
        this.aKh.a(fVar, true);
        this.aKh.ay(false);
        TextView w = this.aKh.w(z.share_tieba_qunzu, v.icon_unite_share_qunzu);
        this.aKh.a(w);
        w.setOnClickListener(new c(this));
        TextView w2 = this.aKh.w(z.forum_friend, v.icon_unite_share_baf);
        this.aKh.a(w2);
        w2.setOnClickListener(new d(this));
        this.aKh.c(new e(this));
        this.aKh.show();
        this.aKh.setOnDismissListener(new f(this));
    }
}
