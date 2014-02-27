package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.util.bq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class v extends a {
    TextView g;
    TextView h;
    TripleTbImageView i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(View view) {
        super(view);
        this.g = (TextView) view.findViewById(R.id.title);
        this.h = (TextView) view.findViewById(R.id.content);
        this.i = (TripleTbImageView) view.findViewById(R.id.images);
    }

    @Override // com.baidu.tieba.person.post.a
    public final void a(int i) {
        super.a(i);
        bq.c(this.g, i);
        bq.d(this.h, i);
    }
}
