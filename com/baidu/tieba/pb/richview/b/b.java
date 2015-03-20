package com.baidu.tieba.pb.richview.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b implements a<View> {
    private com.baidu.adp.lib.e.b<TbImageView> bOo = new com.baidu.adp.lib.e.b<>(new c(this), 12, 0);
    private Context context;
    private int margin;
    private int maxWidth;

    public b(Context context) {
        this.margin = 0;
        this.maxWidth = 0;
        this.context = context;
        this.margin = context.getResources().getDimensionPixelSize(t.ds20);
        this.maxWidth = n.M(context) - (((int) context.getResources().getDimension(t.ds30)) * 2);
    }

    @Override // com.baidu.tieba.pb.richview.b.a
    public int acx() {
        return 3;
    }

    @Override // com.baidu.tieba.pb.richview.b.a
    public View b(com.baidu.tieba.pb.richview.a.c cVar) {
        if (!(cVar instanceof com.baidu.tieba.pb.richview.a.d)) {
            return null;
        }
        TbImageView hz = this.bOo.hz();
        hz.setSupportNoImage(true);
        hz.c(((com.baidu.tieba.pb.richview.a.d) cVar).getSrc(), 17, false);
        hz.setEvent(new d(this, hz));
        hz.setScaleType(ImageView.ScaleType.FIT_XY);
        hz.setVisibility(8);
        return hz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ae(int i, int i2) {
        return (this.maxWidth * i2) / i;
    }

    @Override // com.baidu.tieba.pb.richview.b.a
    public void O(View view) {
        if (view instanceof TbImageView) {
            this.bOo.j((TbImageView) view);
        }
    }

    @Override // com.baidu.tieba.pb.richview.b.a
    public boolean P(View view) {
        return view instanceof TbImageView;
    }
}
