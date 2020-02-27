package com.baidu.tieba.sharesdk.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
/* loaded from: classes11.dex */
public class d extends a {
    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        String str;
        if (shareEntity == null || TextUtils.isEmpty(shareEntity.getContent())) {
            l.showToast(getAppContext(), (int) R.string.share_empty_tip);
            if (bVar != null) {
                bVar.cD(0, 2);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(shareEntity.getContent())) {
            str = shareEntity.getTitle() + shareEntity.getLinkUrl();
        } else {
            str = shareEntity.getContent() + shareEntity.getLinkUrl();
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        if (com.baidu.tieba.sharesdk.c.a.startActivity(this.context, Intent.createChooser(intent, this.context.getString(R.string.share_to)))) {
            if (bVar != null) {
                bVar.cD(0, 1);
            }
        } else if (bVar != null) {
            bVar.cD(0, 2);
        }
    }
}
