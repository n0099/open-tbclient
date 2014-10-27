package com.baidu.tieba.light.share;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class LightappGameShare extends BaseActivity {
    private com.baidu.tbadk.coreExtra.share.d aIb;
    private int blG;
    private int blH;
    private static String REQUEST_CODE = "tb_request_code";
    private static String KEY_FROME_WHERE = "key_from_where";
    private static int blI = 23003;
    private static int blJ = 2;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.lightapp_game_share);
        if (bundle != null) {
            this.blG = bundle.getInt(REQUEST_CODE, 0);
            this.blH = bundle.getInt(KEY_FROME_WHERE, 0);
        } else if (getIntent() != null) {
            this.blG = getIntent().getIntExtra(REQUEST_CODE, 0);
            this.blH = getIntent().getIntExtra(KEY_FROME_WHERE, 0);
        } else {
            finish();
        }
        if (this.blG == blI && this.blH == blJ) {
            Hv();
        }
    }

    public void Hv() {
        ShareFromGameCenterMsgData rU = com.baidu.tbadk.game.b.rS().rU();
        h hVar = new h();
        hVar.title = rU.getTitle();
        hVar.content = rU.getContent();
        hVar.MW = rU.getShareUrl();
        if (StringUtils.isNull(rU.getImageUrl())) {
            hVar.MX = null;
        } else {
            hVar.MX = Uri.parse(rU.getImageUrl());
        }
        this.aIb = new com.baidu.tbadk.coreExtra.share.d(this);
        this.aIb.a(hVar, true);
        this.aIb.ai(false);
        TextView t = this.aIb.t(y.share_tieba_qunzu, u.icon_unite_share_qunzu);
        this.aIb.a(t);
        t.setOnClickListener(new d(this));
        TextView t2 = this.aIb.t(y.forum_friend, u.icon_unite_share_baf);
        this.aIb.a(t2);
        t2.setOnClickListener(new e(this));
        this.aIb.a(new f(this));
        this.aIb.show();
        this.aIb.setOnDismissListener(new g(this));
    }
}
