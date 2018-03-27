package com.baidu.tieba.video.player.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.j.a {
    private View drh;
    private View huT;
    private a huU;

    /* loaded from: classes3.dex */
    public interface a {
        void bCR();

        void bCS();
    }

    public c(Context context) {
        super(LayoutInflater.from(context).inflate(d.h.video_replay_layout, (ViewGroup) null));
        this.drh = this.bxq.findViewById(d.g.video_replay_container);
        this.huT = this.bxq.findViewById(d.g.video_reply_lay);
        this.huT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.player.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.huU != null) {
                    c.this.huU.bCR();
                }
            }
        });
        this.drh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.player.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.huU != null) {
                    c.this.huU.bCS();
                }
            }
        });
    }

    public void a(a aVar) {
        this.huU = aVar;
    }
}
