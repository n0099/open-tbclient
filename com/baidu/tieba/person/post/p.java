package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class p extends a {
    public ReplyLinearLayout g;
    public TextView h;

    public p(View view) {
        super(view);
        this.g = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.h = (TextView) view.findViewById(R.id.original_post_title);
        this.h.setOnClickListener(this);
    }
}
