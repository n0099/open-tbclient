package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
final class t extends a {
    TextView g;
    TextView h;
    TripleTbImageView i;
    View j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(View view) {
        super(view);
        this.g = (TextView) view.findViewById(com.baidu.tieba.a.h.title);
        this.h = (TextView) view.findViewById(com.baidu.tieba.a.h.content);
        this.i = (TripleTbImageView) view.findViewById(com.baidu.tieba.a.h.images);
        this.j = view.findViewById(com.baidu.tieba.a.h.post_line);
    }

    @Override // com.baidu.tieba.person.post.a
    public final void a(int i) {
        super.a(i);
        ba.a(this.g, com.baidu.tieba.a.e.cp_cont_b, 1);
        ba.a(this.h, com.baidu.tieba.a.e.cp_cont_f, 1);
        ba.f(this.j, com.baidu.tieba.a.e.cp_bg_line_b);
    }
}
