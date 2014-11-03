package com.baidu.tieba.light.share;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class LightappGameShare extends BaseActivity {
    private com.baidu.tbadk.coreExtra.share.d aIl;
    GameInfoData aIn = com.baidu.tbadk.game.b.rU().getGameInfoData();
    private int blU;
    private int blV;
    private static String REQUEST_CODE = "tb_request_code";
    private static String KEY_FROME_WHERE = "key_from_where";
    private static int blW = 23003;
    private static int blX = 2;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.lightapp_game_share);
        if (bundle != null) {
            this.blU = bundle.getInt(REQUEST_CODE, 0);
            this.blV = bundle.getInt(KEY_FROME_WHERE, 0);
        } else if (getIntent() != null) {
            this.blU = getIntent().getIntExtra(REQUEST_CODE, 0);
            this.blV = getIntent().getIntExtra(KEY_FROME_WHERE, 0);
        } else {
            finish();
        }
        if (this.blU == blW && this.blV == blX) {
            Hw();
        }
    }

    public void Hw() {
        ShareFromGameCenterMsgData rW = com.baidu.tbadk.game.b.rU().rW();
        h hVar = new h();
        hVar.title = rW.getTitle();
        hVar.content = rW.getContent();
        hVar.Na = rW.getShareUrl();
        if (StringUtils.isNull(rW.getImageUrl())) {
            hVar.Nb = null;
        } else {
            hVar.Nb = Uri.parse(rW.getImageUrl());
        }
        this.aIl = new com.baidu.tbadk.coreExtra.share.d(this);
        this.aIl.a(hVar, true);
        this.aIl.ai(false);
        TextView t = this.aIl.t(y.share_tieba_qunzu, u.icon_unite_share_qunzu);
        this.aIl.a(t);
        t.setOnClickListener(new d(this));
        TextView t2 = this.aIl.t(y.forum_friend, u.icon_unite_share_baf);
        this.aIl.a(t2);
        t2.setOnClickListener(new e(this));
        this.aIl.a(new f(this));
        this.aIl.show();
        this.aIl.setOnDismissListener(new g(this));
    }
}
