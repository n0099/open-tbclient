package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.util.as;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class s extends a {
    TextView g;
    TextView h;
    TripleTbImageView i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(View view) {
        super(view);
        this.g = (TextView) view.findViewById(R.id.title);
        this.h = (TextView) view.findViewById(R.id.content);
        this.i = (TripleTbImageView) view.findViewById(R.id.images);
    }

    @Override // com.baidu.tieba.person.post.a
    public void a(int i) {
        super.a(i);
        as.c(this.g, i);
        as.d(this.h, i);
    }
}
